package com.example.todo.repository;

import com.example.todo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {
    //JDBC
    //1.접속   -- Connection
    //2. 쿼리생성   -- Statement - PreParedStatement, Call~~
    //3. 실행  -     결과  ResultSet
    //4. 결과얻기..

    public List<Todo> findAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Todo> todos = new ArrayList<>();

        try{
            //1.접속
            conn = DBUtil.getConnection();
            String sql = "SELECT ID, TODO, DONE FROM todos ORDER BY ID DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Todo todo = new Todo();
                todo.setId(rs.getLong("id"));
                todo.setContent(rs.getString("todo"));
                todo.setDone(rs.getBoolean("done"));

                todos.add(todo);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        return todos;
    }

    // 저장하는 것.
    // 문자열로 할일을 넘기기
    public void save(String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        // 굳이 resultSet 은 필요 없다.
        // id 값은 자동으로 만들어지도록 했으니 생략, ? 는 매번 실행마다 바뀌어서 해주도록
        String sql = "INSERT INTO todos (todo, done) VALUES (?, false)";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            // 물음표 채워주기 : 물음표 타입 String
            ps.setString(1, content);

            // 이렇게 완성된 쿼리를 실행하기
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);

        }
    }

    // 비즈니스 쪽에서 얘가 뭐야? 라고 해서 맞으면 true 이런식으로 진행
    // Dao 는 로직이 포함되면 안된다 따라서 이걸 쓰지 않게 하기 위해서
    // 애초에 비즈니스 쪽에서 처리된 Todo todo 의 정보를 받아줄것임
    public void update(Todo todo) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE todos SET done=? WHERE id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql); // 여기 안에 sql 이 들어가야함 따라서 미리 위에서 지정
            // 물음표가 두개이니까 완성된 형태가 아님 따라서 아래에서 set
            ps.setBoolean(1, todo.isDone());
            ps.setLong(2, todo.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }

    }

    public void delete(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM todos WHERE id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }
    }

    public Todo findById(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id, todo, done FROM todos WHERE id = ?";
        Todo todo = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            // 물음표 지정해주기
            ps.setLong(1, id); // id가 1인 것 지정
            rs = ps.executeQuery(); // 실행

            if (rs.next()) {
                todo = new Todo();
                todo.setId(rs.getLong("id"));
                todo.setContent(rs.getString("todo"));
                todo.setDone(rs.getBoolean("done"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return todo;
    }

}