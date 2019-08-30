<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<jsp:include page="Toptemplate.jsp"></jsp:include>
<div id="mainwrapper">
	<div id="content">
		<div class="notOnDesktop">
			<!-- This search box is displayed only in mobile and tablet laouts and not in desktop layouts -->
			<input type="text" placeholder="Search">
		</div>
		${news_content}

		<jsp:include page="siderbar.jsp"></jsp:include>
		<footer>
			<div>
				<div align="left">
					<span style="font-size: 20px;"><b>网友评论：</b></span> <span
						style="font-size: 18px; color: #C0C0C0">文明上网理性发言，请遵守<a
						href="http://www.qq.com/coral/coralBeta2/coralinfo.htm"
						style="color: #C0C0C0; text-decoration: none;" target="_blank">新闻评论服务协议</a></span>
				</div>
				<form action="commentservice" method="post">
					<div>
						<textarea class="size" placeholder="说两句吧..."
							style="margin: 0px; height: 101px; width: 650px; float: left;" name="comment_text"></textarea>
					</div>
					<c:if test="${sessionScope.user!=null}">

						<input type="hidden" name="newsid" value="${newsid}">
						<input class="button" type="submit" value="评论">
					</c:if>

				</form>
				<c:if test="${sessionScope.user==null}">

					<input class="button" type="button" value="登录"
						onclick="window.open("login.jsp")">
				</c:if>

			</div>
			<hr style="background: #2DC4CB; color: grey">

			<form>
				<c:if test="${empty comments}">
					<span id="com-tishi">当前暂无评论</span>
				</c:if>
				<c:if test="${! empty comments}">
					<span id="com-tishi">最新评论：</span>
				</c:if>
				<div id="com-all">
					<c:forEach items="${comments}" var="rows">
						<div id="com-total" class="com-all">
							<div id="com-user">${rows[5]}</div>
							<span id="comcontroll">
								<p id="com-con">${rows[3] }</p>
							</span>
							<div id="com-date">${rows[4]}</div>
						</div>
					</c:forEach>
				</div>
			</form>
		</footer>
	</div>
</div>
<div style="margin-bottom: 100px;"></div>
<jsp:include page="footbar.jsp"></jsp:include>

</body>

</html>
