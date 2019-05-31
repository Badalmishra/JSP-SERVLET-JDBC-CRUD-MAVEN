package com.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class TodoDao {
	private Connection conn;

	public TodoDao() throws Exception{
		String url="jdbc:mysql://localhost:3306/java";
	    String user ="root";
	    String pass = "";
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(url,user,pass);
	}
	
    public Todo showTodo(int Tid) throws SQLException {
    	Todo todo = new Todo();
    	int id = Tid;

	        String query ="Select * from todo where id = ?";
	
	        PreparedStatement st = conn.prepareStatement(query);
	
	        st.setInt(1, id);
	
	        ResultSet rs = st.executeQuery();

        if(rs.next()) {
        	todo.setId(rs.getInt("id"));
        	todo.setBody(rs.getString("body"));
        	todo.setStatus(rs.getInt("status"));
        }

        st.close();
    	return todo;
    }
    public LinkedList showAllTodos() throws SQLException {
		
		LinkedList<Todo> list = new LinkedList<Todo>(); 
        String query ="Select * from todo ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
        	Todo todo = new Todo();
        	todo.setId(rs.getInt("id"));
        	todo.setBody(rs.getString("body"));
        	todo.setStatus(rs.getInt("status"));
        	list.add(todo);
        }

        st.close();
    	return list;
    }
    public void deleteTodo(int id) throws SQLException {
        String query ="Delete from todo where id = ?";
    	System.out.println(id);

        PreparedStatement st = conn.prepareStatement(query);

        st.setInt(1, id);
       
        st.executeUpdate();
        st.close();
		
		return;	
    
    }
    public Todo addTodo(String Body) throws SQLException {
    	Todo todo = new Todo();
        String body = Body;

        String query = "Insert Into todo(body) values(?)";

        PreparedStatement st = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        st.setString(1, body);
        int insert_id = 0;
        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()){
          insert_id = rs.getInt(1);
        }
        System.out.println(insert_id);
        todo = (Todo) showTodo(insert_id);
        st.close();
        return todo;
    }
}
