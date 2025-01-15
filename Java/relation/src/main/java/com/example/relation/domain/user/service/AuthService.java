package com.example.relation.domain.user.service;

import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.requestdto.LoginRequestDto;
import com.example.relation.domain.user.dto.requestdto.SignupRequestDto;
import com.example.relation.domain.user.dto.responsedto.SignupResponseDto;
import com.example.relation.domain.user.dto.responsedto.TokenResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    // 비밀번호 암호화
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public SignupResponseDto signup(SignupRequestDto requestDto){

        if(userRepository.existsByUsername(requestDto.getUsername())){
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        if(userRepository.existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        // 비밀번호 암호화 필요
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = requestDto.toEntity(encodedPassword);

        return SignupResponseDto.from(userRepository.save(user));
    }

    // readonly가 되어있어서, transactional이 없어도 괜찮음
    // DB에 데이터를 생성하는게 아니라, JWT를 생성하는 거라서 Transactional은 없어도 됨..! (사실상 조회임)
    // PostMapping이 그럼 필요한가? => RequestBody가 필요하고 그래서 GetMapping은 못 쓰니까

    // 1. DTO를 받습니다.
    public TokenResponseDto login(LoginRequestDto requestDto){
        // 3. 객체로 만든 것을 manager에게 통과시켜 인증이 들어있는 "authentication"객체를 만듭니다.
        // 4. "authenticationManager"를 활용하기 위해 DI를 해줍니다 => Security config로 이동
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        // 2. DTO로부터 온 정보를 객체로 만듭니다.
                        requestDto.getUsername(),
                        requestDto.getPassword()
                )
        );

        // 5. JWT 프로바이더를 DI해줘야 한다. -> jwtTokenProvider를 만들어주자.
        // security / jwt / jwtTokenProvider
        String jwt = jwtTokenProvider.createToken(authentication);

        return new TokenResponseDto(jwt);
    }

}
