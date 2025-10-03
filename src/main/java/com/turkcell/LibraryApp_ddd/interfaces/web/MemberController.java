package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.member.command.CreateMemberCommand;
import com.turkcell.LibraryApp_ddd.application.member.dto.CreatedMemberResponse;
import com.turkcell.LibraryApp_ddd.application.member.dto.MemberResponse;
import com.turkcell.LibraryApp_ddd.application.member.query.ListMembersQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@Validated
public class MemberController {

    private final QueryHandler<ListMembersQuery, List<MemberResponse>> listMembersQueryHandler;
    private final CommandHandler<CreateMemberCommand, CreatedMemberResponse> createMemberCommandHandler;

    public MemberController(QueryHandler<ListMembersQuery, List<MemberResponse>> listMembersQueryHandler, CommandHandler<CreateMemberCommand, CreatedMemberResponse> createMemberCommandHandler) {
        this.listMembersQueryHandler = listMembersQueryHandler;
        this.createMemberCommandHandler = createMemberCommandHandler;
    }

    @GetMapping
    public List<MemberResponse> getMembers(@Valid ListMembersQuery query) {
        return listMembersQueryHandler.handle(query);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedMemberResponse createMember(@Valid CreateMemberCommand command) {
        return createMemberCommandHandler.handle(command);
    }
}

