<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<f:view>
	<h:form>
		<h:messages />
		<fieldset>
		<legend>CHAT</legend>
		
			<h:panelGrid id="gridInternoChat" columns="3">
				<h:column>
					<fieldset>
						<legend>Municipios</legend> 
							<h:panelGrid>
								<a4j:commandButton value="Manter" immediate="true" action="toListaMunicipio" styleClass="botoes"/>
							</h:panelGrid>
					</fieldset>
				</h:column>
				<h:column>
					<fieldset>
						<legend>Pessoas</legend> 
							<h:panelGrid>
								<a4j:commandButton value="Manter" immediate="true" action="toListaPessoa" styleClass="botoes"/>
							</h:panelGrid>
					</fieldset>
				</h:column>
				<h:column>
					<fieldset>
						<legend>Sair</legend> 
							<h:panelGrid>
								<a4j:commandButton value="Sair" immediate="true" action="#{pessoaMB.logout}" styleClass="botoes"/>
							</h:panelGrid>
					</fieldset>
				</h:column>
			
			</h:panelGrid>
			
		</fieldset>
	</h:form>
</f:view>
</body>
</html>