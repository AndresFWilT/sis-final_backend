package sistema.rotondavirtual.ccd.persistance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sistema.rotondavirtual.ccd.persistance.entity.Usuario;
import sistema.rotondavirtual.ccd.persistance.mapper.IUsuarioMapper;

@Repository
public class UsuarioRepository implements IUsuarioMapper {

	// Inyección de independencias
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UsuarioRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Usuario> encontrarUsuario(String id_usuario) {
		return jdbcTemplate.query(
				"SELECT * FROM USUARIO u WHERE u.id_usuario = '" + id_usuario + "'",
				BeanPropertyRowMapper.newInstance(Usuario.class));
	}

	public List<Usuario> listarUsuarios() {
		return jdbcTemplate.query("SELECT u.id_usuario, u.correo_usuario, u.telefono_usuario FROM usuario u",
				BeanPropertyRowMapper.newInstance(Usuario.class));
	}

}
