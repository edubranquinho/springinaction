package br.com.branquinho.tacocloud.service;

import br.com.branquinho.tacocloud.jparepository.UserJpaRepository;
import br.com.branquinho.tacocloud.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userRepositoy;

    public UserRepositoryUserDetailsService(UserJpaRepository userRepositoy) {
        this.userRepositoy = userRepositoy;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepositoy.findByUsername(userName);
        if(user == null) {
            throw new UsernameNotFoundException("Usuário " + userName + " não encontrado");
        }

        return user;
    }
}
