<%-- 
    Document   : report
    Created on : Aug 21, 2022, 7:42:59 PM
    Author     : MrTuan
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TuanDen</title>
        <link rel="stylesheet" href="stylee.css">
    </head>
    <body class="container">
        <jsp:useBean id="dt" class="helper.DateTimeHelper"/>

        <h4>
            <i>
                <b id="banner">Trung Tâm Thương Mại & Giải Trí Khiêm Thành Linh</b> 
            </i>
        </h4>
        <h1 id="banner">BẢNG CHẤM CÔNG</h1>
        <h3>
            <b id="banner">THÁNG 08/2022</b>
        </h3>
        <form class="months" action="report" method="post">
            <p>Tháng</p>
            <input type="month" id="months" name="months">
            <button type="submit">Go</button>
        </form>

        <table clas="container-table" border="1" width="1900px" height="150px">
            <tr></tr>
            <th rowspan="5" >TT</th>
            <th rowspan="5" >Họ Tên</th>
            <th rowspan="5" >Chức Vụ</th>
            <th colspan="31" >Ngày trong tháng</th>
            <th rowspan="5" >Tổng Cộng</th>
            <th rowspan="5" >Đã Ứng</th>
            <th rowspan="5">Tổng Ngày Nghỉ</th>
            <th rowspan="5">Tổng Lương</th>

            <tr></tr>
            <c:forEach items="${requestScope.dates}" var="d">
                <th
                    <c:if test="${dt.getDayOfWeek(d) eq 6 or dt.getDayOfWeek(d) eq 7}">
                        style="background-color: orange;"
                    </c:if>
                    >
                    <fmt:formatDate pattern = "dd" 
                                    value = "${d}" />
                </th>
            </c:forEach>
            <tr></tr>
            <c:forEach items="${requestScope.dates}" var="d">
                <th
                    <c:if test="${dt.getDayOfWeek(d) eq 6 or dt.getDayOfWeek(d) eq 7}">
                        style="background-color: orange;"
                    </c:if>
                    >

                    <fmt:formatDate pattern = "EEE" 
                                    value = "${d}" />
                </th>
            </c:forEach>
            <tr></tr>

            <c:forEach items="${requestScope.totalWorking}" var="tw">
                
                <tr>
                    <td>${tw.eid}</td>
                    <td>${tw.name}</td>
                    <td>${tw.office}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <th
                            <c:if test="${dt.getDayOfWeek(d) eq 6 or dt.getDayOfWeek(d) eq 7}">
                                style="background-color: orange;"
                            </c:if>
                            >
                            <c:forEach items="${requestScope.working}" var="w">
                                <c:if test="${w.wdate eq d && w.eid eq tw.eid}">
                                    x
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${requestScope.leave}" var="l">
                                <c:if test="${l.lfrom >= d && l.lto <=d && l.eid eq tw.eid}">
                                    ${l.reason}
                                </c:if>
                            </c:forEach>

                        </th>

                    </c:forEach>
                    <th>${tw.getNumberOfWorkingDays()}</th>
                    <th></th>
                    <th>${tl.getNumberOfLeaveDays()}</th>
                    <th></th>
                </tr>
                
            </c:forEach>

        </table>
        <br>
        <div id="footer-guild">
            <h2 id="footer-kyhieuchamcong">Ký Hiệu Chấm Công</h2>
            <h2 id="footer-bangtinhluong">Bảng Tính Lương</h2>
        </div>
        <div id="kyhieu">
            <table class="table-kyhieu">
                <tbody>
                    <tr>
                        <th>Ốm, Điều dưỡng</th>
                        <td>O</td>
                    </tr>
                    <tr>
                        <th>Con ốm </th>
                        <td>Co</td>
                    </tr>
                    <tr>
                        <th>Thai sản</th>
                        <td>TS</td>
                    </tr>
                    <tr>
                        <th>Đi Làm </th>
                        <td>X</td>
                    </tr>
                    <tr>
                        <th>Nghỉ Không Lương  </th>
                        <td>K</td>
                    </tr>
                    <tr>
                        <th>Nghỉ Phép</th>
                        <td>P</td>
                    </tr>
                    <tr>
                        <th>Ứng Lương</th>
                        <td>U</td>
                    </tr>

                </tbody>
            </table>
            <p></p>
            <table class="table-tinhluong">
                <tbody>
                    <tr>
                        <th>Giám Đốc</th>
                        <td>400.000vnd/ngày</td>
                    </tr>
                    <tr>
                        <th>Thư Ký/Kế Toán</th>
                        <td>300.000vnd/ngày</td>
                    </tr>
                    <tr>
                        <th>Phó giám Đốc</th>
                        <td>300.000vnd/ngày</td>
                    </tr>
                    <tr>
                        <th>Quản Lý</th>
                        <td>250.000vnd/ngày</td>
                    </tr>
                    <tr>
                        <th>N.v Bán Hàng</th>
                        <td>200.000vnd/ngày</td>
                    </tr>
                    <tr>
                        <th>Bảo Vệ</th>
                        <td>150.000vnd/ngày</td>
                    </tr>
                </tbody>
            </table>
            <div id="footer-button" >
                <button class="button button1">Tổng Ngày Công</button><br>
                <button class="button button1">Tổng Các Ngày Nghỉ</button><br>
                <button class="button button1">Tổng Lương</button><br>
                <button class="button button2">Lưu</button><br>
            </div>

        </div>
    </body>
</html>
