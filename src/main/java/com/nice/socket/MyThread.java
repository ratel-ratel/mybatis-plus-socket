package com.nice.socket;

import com.nice.domain.ReplyInfo;
import com.nice.service.impl.ApplicationContextRegister;
import com.nice.service.impl.ReplyInfoServiceImpl;
import com.nice.utils.BaseResponse;
import com.nice.utils.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
/**
 * Created by yxc on 2019/1/8.
 */
@Service
public class MyThread implements Runnable {
    //采购总金额,订单总数,供应商总数
    private String replyInfo_query_list = "";
    private String new_replyInfo_query_list = "";

    private ReplyInfoServiceImpl workerInfoService;
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        int message=1;
        while (true) {
            try {
                ApplicationContext act = ApplicationContextRegister.getApplicationContext();
                workerInfoService=act.getBean(ReplyInfoServiceImpl.class);
                WebSocketTest wbs = new WebSocketTest();
                ReplyInfo replyInfo=new ReplyInfo();
                //采购总金额,订单总数,供应商总数
                BaseResponse baseResponse = workerInfoService.queryList(replyInfo);
                if (null!=baseResponse) {
                    new_replyInfo_query_list = JsonUtil.objectToJson(baseResponse);
                    if (!replyInfo_query_list.equals(new_replyInfo_query_list)) {
                        System.out.println("change");
                        replyInfo_query_list = new_replyInfo_query_list;
//                        if (message>1){
                            wbs.onMessage("{\n" +
                                    "\t\"dataType\": \"replyInfo_query_list\",\n" +
                                    "\t\"data\":" + replyInfo_query_list + "\n}", null);
//                        }
                    }
                }

                Thread.sleep(3000L);//30 秒访问一次数据库
                message++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    // 获得连接对象
//    private Connection getConn() throws ValidationException {
//        String driver = "oracle.jdbc.OracleDriver";
//        String url = SystemConfig.getProperty("database.url");
//        String username = SystemConfig.getProperty("database.username");
//        String password = SystemConfig.getProperty("database.password");
//        Connection conn = null;
//        if (StringUtils.isEmpty(driver) || StringUtils.isEmpty(url)
//                || StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//            throw new ValidationException("未配置数据源请配置his数据源,或配置缺失");
//        }
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    public List<Map<String,Object>> query(String sql) throws Exception {
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
//        Connection conn = null;
//        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//        try {
//            conn = getConn();
//            pstmt = conn.prepareStatement(sql);
//            //建立一个结果集，用来保存查询出来的结果
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                // 获取列数
//                ResultSetMetaData metaData = rs.getMetaData();
//                int columnCount = metaData.getColumnCount();
//                Map<String, Object> map = new HashMap<>();
//                // 遍历每一列
//                for (int i = 1; i <= columnCount; i++) {
//                    String columnName = metaData.getColumnLabel(i);
//                    String value = rs.getString(columnName);
//                    map.put(columnName, value);
//                }
//                list.add(map);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                    System.out.print("结果集正常关闭。");
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                    System.out.print("关闭编译的 SQL 语句的对象,正常关闭。");
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                    System.out.print("关闭连接(数据库连接对象),正常关闭。");
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        System.out.print("query  his  result  : " + JSONUtils.toJson(list));
//        return list;
//    }

}