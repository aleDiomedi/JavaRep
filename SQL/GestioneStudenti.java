import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestioneStudenti {

	private static final String DB_URL = "jdbc:mysql://didattica.liceocuneo.it:3306/db5E?serverTimezone=Europe/Rome";
	private static final String DB_USER = "quintaf";
	private static final String DB_PWD = "5furra";
	
	private static final String INSERT_STUD = "INSERT INTO DOC_Studente (NrBadge, Cognome, Nome) VALUES (?,?,?)";
	private static final String SELECT_STUD = "SELECT * FROM DOC_Studente";
	private static final String DELETE_STUD = "DELETE FROM DOC_Studente WHERE NrBadge = ?";
	private static final String UPDATE_STUD = "UPDATE DOC_Studente SET Cognome = ?, Nome=? WHERE NrBadge = ?";
	
	
	public void inserisciStudente(Studente s) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//connessione con il dbms
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				  
			//preparare lo statement sql
			stmt = conn.prepareStatement(INSERT_STUD);
			stmt.setString(1, s.getMatricola());
			stmt.setString(2, s.getCognome());
			stmt.setString(3, s.getNome());
			
			//eseguo lo statement
			stmt.executeUpdate();
		
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//chiudere le risorse
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException sqlExc) {}
		}
	}
	
	
	public void aggiornaStudente(Studente s) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//connessione con il dbms
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				  
			//preparare lo statement sql
			stmt = conn.prepareStatement(UPDATE_STUD);
			stmt.setString(1, s.getCognome());
			stmt.setString(2, s.getNome());
			stmt.setString(3, s.getMatricola());
			
			//eseguo lo statement
			stmt.executeUpdate();
		
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//chiudere le risorse
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException sqlExc) {}
		}
	}
	
	public void cancellaStudente(Studente s) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//connessione con il dbms
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				  
			//preparare lo statement sql
			stmt = conn.prepareStatement(DELETE_STUD);
			stmt.setString(1, s.getMatricola());
			
			//eseguo lo statement
			stmt.executeUpdate();
		
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//chiudere le risorse
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException sqlExc) {}
		}
	}
	
	public ArrayList<Studente> leggiStudenti() {
		ArrayList<Studente> ris = new ArrayList<Studente>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//connessione con il dbms
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				  
			//preparare lo statement sql
			stmt = conn.prepareStatement(SELECT_STUD);
						
			//eseguo lo statement
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String nrBadge = rs.getString("NrBadge");
				String c = rs.getString("Cognome");
				String n = rs.getString("Nome");
				Studente s = new Studente(nrBadge, c, n);
				
				ris.add(s);
			}
		
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//chiudere le risorse
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException sqlExc) {}
		}
		return ris;
		
	}
	
	public static void main(String[] args) {
		Studente s1 = new Studente("12345", "Yagami", "Light");
		GestioneStudenti db = new GestioneStudenti();
		db.inserisciStudente(s1);
		
		ArrayList<Studente> lista = db.leggiStudenti();
		for(Studente s: lista) {
			System.out.println(s);
		}
		

	}
}