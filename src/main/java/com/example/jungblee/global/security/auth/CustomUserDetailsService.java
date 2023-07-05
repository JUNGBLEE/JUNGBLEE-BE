package com.example.jungblee.global.security.auth;

import com.example.jungblee.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        return new CustomUserDetails(
                userRepository.findByAccountId(accountId)
                        .orElseThrow(() -> new UsernameNotFoundException("찾을 수 없는 유저입니다.")));
    }
}
