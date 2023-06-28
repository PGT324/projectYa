<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
                <div class="semi">
                     <div align="center">
						<script type="text/javascript">
							alert("${msg}");
							
							opener.location.href='/pro/users/mypage/coupon?users_idx=${login.users_idx}';
							
							window.close();
						
						</script>
					</div>
                </div>
            </div>
              </body>
    </html>
</DoCTYPE>