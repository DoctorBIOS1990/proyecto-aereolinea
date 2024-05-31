/*package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceUsuarioDAO;
import com.springboot.aereolinea.Model.Entity.Usuario;
import com.springboot.aereolinea.Model.Entity.Rol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private InterfaceUsuarioDAO usuarioDAO;

    private Logger logger = (Logger) LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByUsername(username);

        if (usuario == null){
            logger.error("Error Login: No existe el usuario '" + username + "'");
            throw  new UsernameNotFoundException("Username" + username + "no exite en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Rol role: usuario.getRoles()){
            logger.info("Role: ".concat(role.getAuthority() ));
            authorities.add( new SimpleGrantedAuthority(role.getAuthority() ));
        }

        if (authorities.isEmpty() ){
            logger.error("Error login: usuario '" + username + "' no tiene rol asignado!");
            throw  new UsernameNotFoundException("Error login: usuario '\" + username + \"' no tiene rol asignado");
        }
        return new User(usuario.getUsername(), usuario.getPassword(),
                usuario.getEnabled(), true, true, true, authorities);
    }
}*/
