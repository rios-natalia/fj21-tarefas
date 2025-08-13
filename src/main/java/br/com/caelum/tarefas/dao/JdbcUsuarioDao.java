package br.com.caelum.tarefas.dao;

import br.com.caelum.tarefas.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUsuarioDao {
   private final Connection connection;

   @Autowired
   public JdbcUsuarioDao(DataSource dataSource) {
      try {
         this.connection = dataSource.getConnection();
      } catch (SQLException var3) {
         throw new RuntimeException(var3);
      }
   }

   public boolean existeUsuario(Usuario usuario) {
      if (usuario == null) {
         throw new IllegalArgumentException("UsuÃ¡rio nÃ£o deve ser nulo");
      } else {
         try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios where login = ? and senha = ?");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();
            boolean encontrado = rs.next();
            rs.close();
            stmt.close();
            return encontrado;
         } catch (SQLException var5) {
            throw new RuntimeException(var5);
         }
      }
   }
}
