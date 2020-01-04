<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>
	<c:when test="${contribuyente.documentType ne 'NIT' or contribuyente.numBP ne currentUser.numBP }">
		<div class="mt-3">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="firmas.natural.nota" /></label>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="mt-3">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="firmas.natural.nota2" /></label>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>



