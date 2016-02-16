/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuripay.messages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kuripay.util.MyConnection;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_messages {

    public static class message_room {

        public final String row;
        public final String message;

        public message_room(String row, String message) {
            this.row = row;
            this.message = message;
        }
    }

    public static class to_messages {

        public final int id;
        public final String contact_no;
        public final String status;
        public final String message;
        public final String date_sent;
        public final String date_added;
        public final int index_no;

        public to_messages(int id, String contact_no, String status, String message, String date_sent, String date_added, int index_no) {
            this.id = id;
            this.contact_no = contact_no;
            this.status = status;
            this.message = message;
            this.date_sent = date_sent;
            this.date_added = date_added;
            this.index_no = index_no;
        }
    }

    public static void add_messages(to_messages to_messages) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into messages("
                    + "contact_no"
                    + ",status"
                    + ",message"
                    + ",date_sent"
                    + ",date_added"
                    + ",index_no"
                    + ")values("
                    + ":contact_no"
                    + ",:status"
                    + ",:message"
                    + ",:date_sent"
                    + ",:date_added"
                    + ",:index_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("contact_no", to_messages.contact_no)
                    .setString("status", to_messages.status)
                    .setString("message", to_messages.message)
                    .setString("date_sent", to_messages.date_sent)
                    .setString("date_added", to_messages.date_added)
                    .setNumber("index_no", to_messages.index_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_messages.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_messages(to_messages to_messages) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update messages set "
                    + "contact_no= :contact_no"
                    + ",status= :status"
                    + ",message= :message"
                    + ",date_sent= :date_sent"
                    + ",date_added= :date_added"
                    + ",index_no= :index_no"
                    + " where "
                    + " id ='" + to_messages.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("contact_no", to_messages.contact_no)
                    .setString("status", to_messages.status)
                    .setString("message", to_messages.message)
                    .setString("date_sent", to_messages.date_sent)
                    .setString("date_added", to_messages.date_added)
                    .setNumber("index_no", to_messages.index_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_messages.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_messages(to_messages to_messages) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from messages where "
                    + " id ='" + to_messages.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_messages.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_messages> ret_data(String where) {
        List<to_messages> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",contact_no"
                    + ",status"
                    + ",message"
                    + ",date_sent"
                    + ",date_added"
                    + ",index_no"
                    + " from messages  "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String contact_no = rs.getString(2);
                String status = rs.getString(3);
                String message = rs.getString(4);
                String date_sent = rs.getString(5);
                String date_added = rs.getString(6);
                int index_no = rs.getInt(7);

                to_messages to = new to_messages(id, contact_no, status, message, date_sent, date_added, index_no);
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
