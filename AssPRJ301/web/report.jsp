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
        <title>JSP Page</title>
        <link rel="stylesheet" href="stylee.css">
    </head>
    <body class="container">
    <h4>
        <i>
            <b id="banner">Trung Tâm Thương Mại & Giải Trí Khiêm Thành Linh</b> 
        </i>
    </h4>
    <h1 id="banner">BẢNG CHẤM CÔNG</h1>
    <h3>
        <b id="banner">THÁNG 08/2022</b>
    </h3>
    <h4>
        <i>
            <b><select class="month">
                    <option>Tháng 1</option>
                    <option>Tháng 2</option>
                    <option>Tháng 3</option>
                    <option>Tháng 4</option>
                    <option>Tháng 5</option>
                    <option>Tháng 6</option>
                    <option>Tháng 7</option>
                    <option>Tháng 8</option>
                    <option>Tháng 9</option>
                    <option>Tháng 10</option>
                    <option>Tháng 11</option>
                    <option>Tháng 12</option>
                </select></b>
        </i>
    </h4>
    <table clas="container-table" border="1" width="1900px" height="150px">
        <tr></tr>
        <th rowspan="5" id="container">TT</th>
            <th rowspan="5" id="container">Họ Tên</th>
            <th rowspan="5" id="container">Chức Vụ</th>
            <th colspan="31" id="container">Ngày trong tháng</th>
            <th rowspan="5" id="container">Tổng Cộng</th>
            <th rowspan="5" id="container">Đã Ứng</th>
            <th rowspan="4" colspan="3" id="container">Ngày Nghỉ</th>
            <th rowspan="5" id="container">Tổng Lương</th>
            
            
        <tr></tr>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
            <th>6</th>
            <th>7</th>
            <th>8</th>
            <th>9</th>
            <th>10</th>
            <th>11</th>
            <th>12</th>
            <th>13</th>
            <th>14</th>
            <th>15</th>
            <th>16</th>
            <th>17</th>
            <th>18</th>
            <th>19</th>
            <th>20</th>
            <th>21</th>
            <th>22</th>
            <th>23</th>
            <th>24</th>
            <th>25</th>
            <th>26</th>
            <th>27</th>
            <th>28</th>
            <th>29</th>
            <th>30</th>
            <th>31</th>
        <tr></tr>
            <th>Thứ sáu</th>
            <th>Thứ bảy</th>
            <th>Chủ nhật</th>
            <th>Thứ hai</th>
            <th>Thứ ba</th>
            <th>Thứ tư</th>
            <th>Thứ năm</th>
            <th>Thứ sáu</th>
            <th>Thứ bảy</th>
            <th>Chủ nhật</th>
            <th>Thứ hai</th>
            <th>Thứ ba</th>
            <th>Thứ tư</th>
            <th>Thứ năm</th>
            <th>Thứ sáu</th>
            <th>Thứ bảy</th>
            <th>Chủ nhật</th>
            <th>Thứ hai</th>
            <th>Thứ ba</th>
            <th>Thứ tư</th>
            <th>Thứ năm</th>
            <th>Thứ sáu</th>
            <th>Thứ bảy</th>
            <th>Chủ nhật</th>
            <th>Thứ hai</th>
            <th>Thứ ba</th>
            <th>Thứ tư</th>
            <th>Thứ năm</th>
            <th>Thứ sáu</th>
            <th>Thứ bảy</th>
            <th>Chủ nhật</th>
            <th>Nghỉ Không Lương</th>
            <th>Nghỉ Phép</th>
            <th>Lí Do Khác</th>
        <tr></tr>
     
            
         
        <tr>
            <th>1</th>
            <th>Khúc Chí Khoản</th>
            <th>Giám Đốc</th>
            <th>x</th>
            <th>x</th>
            <th>P</th>
            <th>P</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x|U</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>K</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>K</th>
            <th>K</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>26</th>
            <th>4.000.000</th>
            <th>3.0</th>
            <th>2.0</th>
            <th>0</th>
            <th>6.400.000</th>
        </tr>
        <tr>
            <th>2</th>
            <th>Nguyễn Thị Liễu</th>
            <th>Thư Ký/Kế Toán</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x|U</th>
            <th>P</th>
            <th>P</th>
            <th>P</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>28</th>
            <th>4.000.000</th>
            <th>0</th>
            <th>3</th>
            <th>0</th>
            <th>4.400.000</th>
        </tr>
        <tr>
            <th>3</th>
            <th>Khúc Chí Khiêm</th>
            <th>Phó giám Đốc/Quản Lý</th>
            <th>O|U</th>
            <th>O</th>
            <th>O</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>P|U</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>K</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>26</th>
            <th>5.500.000</th>
            <th>1</th>
            <th>1</th>
            <th>3</th>
            <th>2.300.000</th>
        </tr>
        <tr>
            <th>4</th>
            <th>Khúc Chí Thành</th>
            <th>Quản Lý</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>31</th>
            <th>0</th>
            <th>0</th>
            <th>0</th>
            <th>0</th>
            <th>7.750.000</th>
        </tr>
        <tr>
            <th>5</th>
            <th>Nguyễn Thị Thêu</th>
            <th>N.v Bán Hàng</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x|U</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>Co</th>
            <th>Co|U</th>
            <th>Co</th>
            <th>Co</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>x</th>
            <th>27</th>
            <th>3.000.000</th>
            <th>0</th>
            <th>0</th>
            <th>4</th>
            <th>2.400.000</th>
        </tr>
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
