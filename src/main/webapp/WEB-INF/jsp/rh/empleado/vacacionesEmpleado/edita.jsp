<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:message code="vacacionesEmpleado.edita.label" /></title>
    </head>
    <body>
        <br/>
        <br/>
        <br/>
        <br/>
        <jsp:include page="../menu.jsp" >
            <jsp:param name="menu" value="vacaciones" />
        </jsp:include>

        <div id="nuevo-nacionalidad" class="content scaffold-list" role="main">
            <h1><s:message code="vacacionesEmpleado.edita.label" /></h1>
            <p class="well">
                <a class="btn btn-primary" href="<s:url value='/rh/vacacionesEmpleado'/>"><i class="icon-list icon-white"></i> <s:message code='vacacionesEmpleado.lista.label' /></a>
            </p>
            <c:url var="actualizaUrl" value="/rh/vacacionesEmpleado/graba" />
            <form:form commandName="vacacionEmpleado" action="${actualizaUrl}" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />
                <form:errors path="*">
                    <div class="alert alert-block alert-error fade in" role="status">
                        <a class="close" data-dismiss="alert">×</a>
                        <c:forEach items="${messages}" var="message">
                            <p>${message}</p>
                        </c:forEach>
                    </div>
                </form:errors>

                <fieldset>
                    <s:bind path="vacacionEmpleado.descripcion">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                                <label for="descripcion">
                                <s:message code="descripcion.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="descripcion" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="descripcion" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                    <s:bind path="vacacionEmpleado.numDias">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                                <label for="numDias">
                                <s:message code="dias.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <select name="signo">  
                                <option value="+" selected>+</option>  
                                <option value="-">-</option>  
                            </select> 
                            <form:input path="numDias" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="numDias" cssClass="alert alert-error" />
                        </div>
                    </s:bind>



                </fieldset>

                <p class="well" style="margin-top: 10px;">
                    <button type="submit" name="actualizarBtn" class="btn btn-primary btn-large" id="actualizar" ><i class="icon-ok icon-white"></i>&nbsp;<s:message code='actualizar.button'/></button>
                    <a class="btn btn-large" href="<s:url value='/rh/vacacionesEmpleado/ver/${vacacionEmpleado.id}'/>"><i class="icon-remove"></i> <s:message code='cancelar.button' /></a>
                </p>
            </form:form>
        </div>
    <content>
        <script>
            $(document).ready(function() {
                $('input#nombre').focus();
                $("input#fecha").datepicker($.datepicker.regional['es']);
                $("input#fecha").datepicker("option", "firstDay", 0);
            });

        </script>                    
    </content>
</body>
</html>
