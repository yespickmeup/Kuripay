package kuripay.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kuripay.util.MyConnection;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guinness
 */
public class S1_members {

    public static class to_members {

        public final int id;
        public final String fname;
        public final String lname;
        public final String mi;
        public final String department;
        public final String contact_no;
        public final String email_address;
        public int selected;

        public to_members(int id, String fname, String lname, String mi, String department, String contact_no, String email_address, int selected) {
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.mi = mi;
            this.department = department;
            this.contact_no = contact_no;
            this.email_address = email_address;
            this.selected = selected;
        }

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }
    }

    public static void add_members(to_members to_members) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into members("
                    + "fname"
                    + ",lname"
                    + ",mi"
                    + ",department"
                    + ",contact_no"
                    + ",email_address"
                    + ")values("
                    + ":fname"
                    + ",:lname"
                    + ",:mi"
                    + ",:department"
                    + ",:contact_no"
                    + ",:email_address"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("fname", to_members.fname)
                    .setString("lname", to_members.lname)
                    .setString("mi", to_members.mi)
                    .setString("department", to_members.department)
                    .setString("contact_no", to_members.contact_no)
                    .setString("email_address", to_members.email_address)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_members.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_members(to_members to_members) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update members set "
                    + "fname= :fname"
                    + ",lname= :lname"
                    + ",mi= :mi"
                    + ",department= :department"
                    + ",contact_no= :contact_no"
                    + ",email_address= :email_address"
                    + " where "
                    + " id ='" + to_members.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("fname", to_members.fname)
                    .setString("lname", to_members.lname)
                    .setString("mi", to_members.mi)
                    .setString("department", to_members.department)
                    .setString("contact_no", to_members.contact_no)
                    .setString("email_address", to_members.email_address)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_members.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_members(to_members to_members) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from members where "
                    + " id ='" + to_members.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_members.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_members> ret_data(String where) {
        List<to_members> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",fname"
                    + ",lname"
                    + ",mi"
                    + ",department"
                    + ",contact_no"
                    + ",email_address"
                    + " from members  "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String mi = rs.getString(4);
                String department = rs.getString(5);
                String contact_no = rs.getString(6);
                String email_address = rs.getString(7);

                to_members to = new to_members(id, fname, lname, mi, department, contact_no, email_address, 1);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
