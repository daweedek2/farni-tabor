package cz.kostka.farnitabor.controller;

import cz.kostka.farnitabor.domain.Member;
import cz.kostka.farnitabor.dto.ValidationDto;
import cz.kostka.farnitabor.service.MemberService;
import cz.kostka.farnitabor.service.PlaceService;
import cz.kostka.farnitabor.service.GameService;
import cz.kostka.farnitabor.utils.MemberDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by dkostka on 7/8/2021.
 */
@Controller
public class GroupColorGameController {
    public static final String ERROR_TEXT_ATTR = "error";
    public static final String MEMBER_DTO_ATTR = "memberDto";
    public static final String FAIL_ATTR = "fail";
    private final GameService gameService;
    private final PlaceService placeService;
    private final MemberService memberService;

    @Autowired
    public GroupColorGameController(
            final GameService gameService,
            final PlaceService placeService,
            final MemberService memberService) {
        this.gameService = gameService;
        this.placeService = placeService;
        this.memberService = memberService;
    }

    @GetMapping
    public String getHomePage(final Model model) {
        model.addAttribute("dto", new ValidationDto());
        model.addAttribute("places", placeService.getAll());
        return "game";
    }

    @GetMapping("/success")
    public String getSuccessPage(final Model model) {
        model.addAttribute("places", placeService.getAll());
        return "result";
    }

    @GetMapping("/list")
    public String getMembersList(final Model model) {
        model.addAttribute("members", memberService.getAllMembersDtos());
        return "list";
    }

    @PostMapping("/validate")
    public String validate(final @ModelAttribute ValidationDto dto, final RedirectAttributes redirectAttributes) {
        final var memberOptional = memberService.findByName(dto.getName());
        if (memberOptional.isEmpty()) {
            redirectAttributes.addFlashAttribute(FAIL_ATTR, true);
            redirectAttributes.addFlashAttribute(
                    ERROR_TEXT_ATTR,
                    "Neznámé jméno, zadej celé jméno s diakritikou (např.: Jiří Novák).");
            return "redirect:";
        }

        final var member = memberOptional.get();
        if (member.getFoundPlaces().size() == 4) {
            redirectAttributes.addFlashAttribute(MEMBER_DTO_ATTR, MemberDtoUtil.convertMemberToDto(member));
            return "redirect:success";
        }

        final var placeOpt = placeService.getByCode(dto.getCode());
        if (placeOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute(FAIL_ATTR, true);
            redirectAttributes.addFlashAttribute(
                    ERROR_TEXT_ATTR,
                    "Zadaný kód není správný, zkus to znovu.");

            return "redirect:";
        }

        final var place = placeOpt.get();

        final var isCorrect = gameService.validate(member, place);
        if (!isCorrect) {
            redirectAttributes.addFlashAttribute(FAIL_ATTR, true);
            redirectAttributes.addFlashAttribute(
                    ERROR_TEXT_ATTR,
                    "Chyba aplikace, zkus to prosím znovu.");
            return "redirect:";
        }

        final Member updatedMember = memberService.getById(member.getId());
        redirectAttributes.addFlashAttribute(MEMBER_DTO_ATTR, MemberDtoUtil.convertMemberToDto(updatedMember));
        return "redirect:success";
    }
}
