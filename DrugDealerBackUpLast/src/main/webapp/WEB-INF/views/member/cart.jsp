<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.drug.dto.OrderDto"%>
<%@ page import="java.util.*"%>
<html lang="en">
    <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
    </script>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>My Page</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/cart.css" rel="stylesheet" />
        <style>
            li a{
                text-decoration: none;
                color: rgba(0, 0, 0, 0.767);
            }
        </style>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript">
      $(document).ready(function() {
         $("#allCheck").click(function() {
            if($("#allCheck").is(":checked")) $("input[name=chBox]").prop("checked", true);            
            else $("input[name=chBox]").prop("checked", false);
         });
         
         $("input[name=chBox]").click(function() {
            var total = $("input[name=chBox]").length;
            var checked = $("input[name=chBox]:checked").length;
            
            if(total != checked) $("#allCheck").prop("checked", false);
            else $("#allCheck").prop("checked", true); 
         });
      });      
 
       function Delete(){
          //체크박스 체크된 항목
          const query = 'input[name="chBox"]:checked'
          const selectedElements = document.querySelectorAll(query)

          //체크박스 체크된 항목의 개수
          const selectedElementsCnt = selectedElements.length;

          if(selectedElementsCnt == 0){
              alert("삭제할 항목을 선택해주세요.");
              return false;
          }

          else{
              if (confirm("정말로 삭제하시겠습니까?")) {
                 
            	 var arr=new Array();
            	  $("input:checkbox[name='chBox']:checked").each(function() {
            	  arr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
            	  console.log(arr);
            	})

            	  $.ajax({
            	      type  : "GET",
            	      url    : "<c:url value='/member/cart/delete'/>",
            	      data: {
            	      arr : arr        // folder seq 값을 가지고 있음.
            	      },
            	      success: function(result){
            	    	 location.href="/ex/member/cart/selectAll"
            	         console.log(result);
            	      },
            	      error: function(xhr, status, error) {
            	         alert(error);
            	      }  
            	   });

               
       
              }
          }
      }
      function Order(){
    	   	  //체크박스 체크된 항목    	   	   
    	       query = 'input[name="chBox"]:checked'
    	       selectedElements = document.querySelectorAll(query)

    	       //체크박스 체크된 항목의 개수
    	       selectedElementsCnt = selectedElements.length;
    	       
    	       if(selectedElementsCnt == 0){
    	           alert("구매할 목록을 선택해주세요.");
    	           return false;
    	       }
    	       else{
    	    	   let form_contents="";
    	    	   let orderNum=0;
    	    	   <%ArrayList<OrderDto> dtos = new ArrayList<OrderDto>();%>
    	    	   $(".order_cart").each(function(){
    	    		   if($(this).find(".chBox").is(":checked")===true){
    	    		   let pn = $(this).find(".pn").val();    	    		   
    	    		   let price =$(this).find(".price").val();
    	    		   let quantity =$(this).find(".quantity").val();
    	    		   let inventory =$(this).find(".inventory").val();
    	    		   let id =$(this).find(".id").val();
    	    		   let pn_input="<input name='orders["+orderNum+"].pn' type='hidden' value='"+pn+"'>";
    	    		   form_contents+=pn_input;
    	    		   let price_input="<input name='orders["+orderNum+"].price' type='hidden' value='"+price+"'>";
    	    		   form_contents+=price_input;
    	    		   let quantity_input="<input name='orders["+orderNum+"].quantity' type='hidden' value='"+quantity+"'>";
    	    		   form_contents+=quantity_input;
    	    		   let inventory_input="<input name='orders["+orderNum+"].inventory' type='hidden' value='"+inventory+"'>";
    	    		   form_contents+=inventory_input;
    	    		   let id_input="<input name='orders["+orderNum+"].id' type='hidden' value='"+id+"'>";
    	    		   form_contents+=id_input;
    	    		   orderNum+=1;
    	    		   }
    	    	   });    	    	   
    	    	   alert(form_contents);
    	      		$(".order_form").html(form_contents);
    	      		$(".order_form").submit();    	
    	       }     
      }
   </script>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="/ex/">DrugStore</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="/ex/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/ex/login/login">Sign In</a></li>
                            <li class="nav-item"><a class="nav-link" href="pricing.html">Pricing</a></li>
                            <li class="nav-item"><a class="nav-link" href="faq.html">FAQ</a></li>                            
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Page Content-->
            <section class="cart">
              			 <table>
               			<thead>
               			<tr>               		               				
               			<td>${id }님의 장바구니</td>               			
               			</tr>
               			<tr><td>　</td></tr>
              			</thead>
              			</table>
            
                <table class="cart__list">
                
                		
      
                        
                        <thead>
                     
                            <tr>
                                <td><input type="checkbox" name="allCheck" id="allCheck" checked="checked" class="allCheck"></td>
                                <td colspan="2">상품 정보</td>
                                <td>옵션</td>
                                <td>상품 금액</td>
                            </tr>
                        </thead>
                        
                        
                        <tbody>
                        <c:set var="finalPrice" value="0"/>
                        <c:forEach items="${list}" var="dto">
                            <tr class="cart__list__detail">
                                <td class="order_cart">
                                <input type="checkbox" name="chBox" class="chBox" checked="checked" data-cn="${dto.cn }" value="${dto.cn }">
                                <input type="hidden" class="pn" name="pn" value="${dto.pn }">
                                <input type="hidden" class="price" name="price" value="${dto.price }">
                                <input type="hidden" class="quantity" name="quantity" value="${dto.quantity }">
                                <input type="hidden" class="id" name="id" value="${dto.id }">
                                <input type="hidden" class="inventory" name="inventory" value="${dto.inventory }">                               
                                </td>
           
                                <td><img src="image/keyboard.jpg" alt="magic keyboard"></td>
                                <td>
                                    <p><a href="#">${dto.name }</a></p>
                                    <c:set var="totalPrice" value="${dto.quantity * dto.price }"/>
                                    <font color="lightgray">$ ${dto.price}</font>
                                </td>
                                <td class="cart__list__option">
                                    <p>수량 : ${dto.quantity }개</p>
                                    <button class="cart__list__optionbtn">주문조건 추가/변경</button>
                                </td>
                                <td><span class="price">$ ${totalPrice }</span><br>
                                <form action="/ex/order/insert" id='orderOne' method="post">
                                <input type="hidden" name="pn" value="${dto.pn }">
                                <input type="hidden" name="price" value="${dto.price }">
                                <input type="hidden" name="quantity" value="${dto.quantity }">
                                <input type="hidden" name="id" value="${dto.id }">
                                <input type="hidden" name="inventory" value="${dto.inventory }">
                                
                                    <button class="cart__list__orderbtn" type=submit formaction="/ex/order/insert">주문하기</button>
                                    </form>
                                </td>
                            </tr>
     
                            <c:set var="finalPrice" value="${finalPrice+totalPrice }"/>
                           	<c:set var="id" value="${dto.id }"/>
						</c:forEach>
						
						
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="3"><button type="button" class="cart__list__orderbtn" id="deleteBtn" name="cn" onclick="Delete()">선택 상품 삭제</button>

                                <button class="cart__list__optionbtn"><a href="/ex/member/cart/deleteAll?id=${id}">장바구니 비우기</button></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            
                        </tfoot>  
                        <form action="/ex/order/insertCheck" method="post" class="order_form"></form>                    
                </table>
              
                <h5>결제 예정 금액 : $ ${finalPrice }</h5>
                <div class="cart__mainbtns">
                    <button class="cart__bigorderbtn left"><a href="/ex/selectAll">쇼핑 계속하기</a></button>
                    <button type="button" class="cart__bigorderbtn right" id="orderBtn" name="order" onclick="Order()">주문하기</button>
                </div>
            </section>
        </main>
        <!-- Footer-->
        <footer class="bg-dark py-4 mt-auto">
            <div class="container px-5">
                <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                    <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; Your Website 2022</div></div>
                    <div class="col-auto">
                        <a class="link-light small" href="#!">Privacy</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Terms</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Contact</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
