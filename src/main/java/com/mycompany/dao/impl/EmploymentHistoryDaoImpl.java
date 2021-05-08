
package com.mycompany.dao.impl;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryGetById(int userId) {
        List<EmploymentHistory> lists = new ArrayList<>();
        try {
            Connection c = connect();

            PreparedStatement pstmt = c.prepareStatement(" select * from employment_history as eh where eh.user_id =" + userId);
            pstmt.execute();
            ResultSet r = pstmt.getResultSet();
            while (r.next()) {
                EmploymentHistory eh = checkEmploymentHistory(r);
                lists.add(eh);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return lists;
    }

    private EmploymentHistory checkEmploymentHistory(ResultSet r) {
        EmploymentHistory eh = null;
        try {
            int id = r.getInt("id");
            Date beginDate = r.getDate("begin_date");
            Date endDate = r.getDate("end_date");
            String jobDescription = r.getString("job_description");
            int userId = r.getInt("user_id");
            eh = new EmploymentHistory(id, beginDate, endDate, jobDescription, new User(userId));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return eh;
    }

    @Override
    public boolean removeEmpolymetHistroy(User u) {
        boolean result = false;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            result = stmt.execute("delete * from employment_history where employment_history.id=" + u.getId());
            c.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean updateEmploymetHistroy(EmploymentHistory eh) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("update employment_histroy set  begin_date=?,end_date=?,job_descripition=? where id=" + eh.getId());
            pstmt.setDate(1, eh.getBeginDate());
            pstmt.setDate(2, eh.getEndDate());
            pstmt.setString(3, eh.getJobDescription());
            return result = pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addEmploymetHistroy(EmploymentHistory eh) {

        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("insert into employment_histroy (begin_date,end_date_job_descripiyion,user_id) values(?,?,?.?)");
            pstmt.setDate(1, eh.getBeginDate());
            pstmt.setDate(2, eh.getEndDate());
            pstmt.setString(3, eh.getJobDescription());
            pstmt.setInt(4, eh.getUser().getId());
            return result = pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public EmploymentHistory getByIdEmploymentHistroy(int userId) {
        EmploymentHistory eh = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from employment_history as eh where eh.user_id=" + userId);
            ResultSet r = stmt.getResultSet();

            while (r.next()) {
                eh = checkEmploymentHistory(r);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eh;
    }

}
