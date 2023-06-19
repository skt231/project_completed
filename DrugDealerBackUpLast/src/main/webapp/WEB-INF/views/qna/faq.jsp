<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>Shop</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon1.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/resources/css/styles1.css" rel="stylesheet" type="text/css"/>
    </head>
        <style type="text/css">
        *{
        margin: auto;
        width: 100%;
        }
    body.d-flex flex-column h-100{
    margin: auto;
    }
           .text-muted_mb-4 button{
            border:1px #F8F9FA;
           }
           button a{
           color: blue;
           text-decoration: none;
           } 
           
        
        </style>

    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
           
            <!-- Page Content-->
            <section class="py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                        <h2 class="fw-bolder">자주 물어보는 질문</h2>
                    </div>
                    <div class="row gx-5">
                        <div class="col-xl-8">
                            <!-- FAQ Accordion 1-->
                            <div class="accordion mb-5" id="accordionExample">
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingOne"><button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">어떻게 주문을 인증하거나 확인하나요?</button></h3>
                                    <div class="accordion-collapse collapse show" id="collapseOne" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            고객님께서는 주문 확인을 위해 승인 금액(또는 '소액 결제 인증') 또는 승인번호를 제공하여야 하실 수도 있습니다. <br>이러한 승인 금액 또는 승인번호는 은행 명세서 또는 은행에 직접 문의하여 확인하실 수 있습니다.

주문 페이지에서 청구된 현지 통화로 승인 금액에 입력해 주십시오. <br>짧은 시간 내에 여러 건의 주문을 하실 경우, 여러 번 승인 금액을 제공하여야 할 수도 있습니다. 총액이 아니라 주문에 해당하는 각각의 각 금액을 개별적으로 입력해 주십시오.<br>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingTwo"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">주문을 취소할 수 있나요?</button></h3>
                                    <div class="accordion-collapse collapse" id="collapseTwo" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            대부분의 주문은 1시간 내로 배송이 시작됩니다. 배송이 시작되면 iHerb에서 주문을 취소할 수 없습니다. <br>주문 물품을 받으신 후 고객센터를 통해 반품을 신청해 주시기 바랍니다. <br>배송 물품들이 원상태로 반품되는 즉시 환불해 드리도록 하겠습니다.
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingThree"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">상품이 예전과 달라 보입니다. 품질의 문제인가요?</button></h3>
                                    <div class="accordion-collapse collapse" id="collapseThree" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            제조사는 계속해서 상품 개선을 위해 노력하고 있습니다. 당사는 각 상품의 포장, 영양 성분, 상세 정보 업데이트에 최선을 다하고 있지만 간혹 변경 사항이 있을 수 있으므로 제조사에 직접 문의를 권장해 드립니다. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                      
                        <div class="col-xl-4">
                            <div class="card border-0 bg-light mt-xl-5">
                                <div class="card-body p-4 py-lg-5">
                                    <div class="d-flex align-items-center justify-content-center">
                                        <div class="text-center">
                                            <div class="h6 fw-bolder">다른 도움이 <br>필요하신가요?</div>
                                            <p class="text-muted_mb-4">
                                                Contact us at
                                                <br />
                                                <button ><a href="/ex/qna/list">문의하기</a></button>
                                            </p>
                                            <div class="h6 fw-bolder">Follow us</div>
                                            <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-twitter"></i></a>
                                            <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-facebook"></i></a>
                                            <a class="fs-5 px-2 link-dark" href="https://www.instagram.com/foxmangrape/?igshid=NTdlMDg3MTY%3D"><i class="bi-linkedin"></i></a>
                                            <a class="fs-5 px-2 link-dark" href="https://www.youtube.com/@suminpark8079"><i class="bi-youtube"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
  <%@include file="../include/footer.jsp"%>
  </body>
  </html>
