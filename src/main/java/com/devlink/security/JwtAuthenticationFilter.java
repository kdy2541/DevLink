package com.devlink.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
        throws ServletException, IOException {

        // 요청 헤더에서 Authorization 값 추출
        String header = request.getHeader("Authorization");

        // Bearer 토큰이 아니면 통과
        if(header == null || !header.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        // Bearer 부분 제거 후 토큰만 추출
        String token = header.substring(7);

        // 유효한 토큰 확인
        if(jwtTokenProvider.validateToken(token)){
            String userEmail = jwtTokenProvider.getEmailFromToken(token);

            //사용자 정보로 인증 객체 생성
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    userEmail, null, null
            );
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            //SecurityContext에 인증 객체 저장
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}
