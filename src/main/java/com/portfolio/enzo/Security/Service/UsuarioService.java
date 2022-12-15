
package com.portfolio.enzo.Security.Service;

import com.portfolio.enzo.Security.Entity.Usuario;
import com.portfolio.enzo.Security.Repository.IntUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
 @Autowired
 IntUsuarioRepository intusuarioRepository;
 
 public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
     return intusuarioRepository.findByNombreUsuario(nombreUsuario);
 }
 
 public boolean existsByNombreUsuario(String nombreUsuario){
     return intusuarioRepository.existsByNombreUsuario(nombreUsuario);
 }
 
 public boolean existsByEmail(String email){
     return intusuarioRepository.existsByEmail(email);
 }
 
 public void save(Usuario usuario){
     intusuarioRepository.save(usuario);
 }
}
