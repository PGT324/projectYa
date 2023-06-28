<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
                <div class="semi">
                     <div align="center">
						<script type="text/javascript">
							alert("${msg}");
							location.href="${href }" + "?users_idx=${login.users_idx}";
						</script>
					</div>
                </div>
            </div>
              </body>
    </html>
</DoCTYPE>
            