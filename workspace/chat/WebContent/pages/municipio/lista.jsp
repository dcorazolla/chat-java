<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<h:form id="formListaMunicipio">
		<a4j:keepAlive beanName="municipioMB" />
		<h:messages/>
	
		 <fieldset>
	        <legend>Lista de Municipios</legend>
			
			<rich:dataTable value="#{municipioMB.municipios}" var="municipio" rows="10" id="municipios" width="100%" cellspacing="0" cellpadding="0" border="1">
			
				<h:column>
					<f:facet name="header">
						<h:outputText value="NOME" />
					</f:facet>
					<h:outputText value="#{municipio.nome}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="UF" />
					</f:facet>
					<h:outputText value="#{municipio.uf}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="PAIS" />
					</f:facet>
					<h:outputText value="#{municipio.pais}" />
				</h:column>
				
				<h:column>
					<a4j:commandLink reRender="panelGridInputs">
						<h:outputText value="Alterar"/>
						<f:setPropertyActionListener  value="#{municipio}" target="#{municipioMB.municipio}"/>
					</a4j:commandLink>
				</h:column>
				
				<h:column>
					<a4j:commandLink action="#{municipioMB.delete}" status="sts" reRender="municipios">
						<h:outputText value="apagar"/>
						<f:setPropertyActionListener  value="#{municipio.id}" target="#{municipioMB.id}"/>
					</a4j:commandLink>
				</h:column>
				
				<f:facet name="footer">
					<rich:datascroller />
				</f:facet>
				
			</rich:dataTable>
			
			<rich:messages/>
			
    	    <a4j:region id="regiaoAjax">
			 	<a4j:status id="sts">
	            	<f:facet name="start">
	            		<h:graphicImage value="/images/ajax-loader.gif" />
	               	</f:facet>
	            </a4j:status>
	        </a4j:region>

<br>
	        
	        <h:panelGrid columns="2" id="panelGridInputs">

				<h:outputLabel for="nome" value="Nome "  />
				<h:inputText id="nome" value="#{municipioMB.municipio.nome}" style=" width : 254px;"/>
				
				<h:outputLabel for="uf" value="UF "  />
				<h:inputText id="email" value="#{municipioMB.municipio.uf}" style=" width : 20px;" />
				
				<h:outputLabel for="pais" value="Pais "  />
				<h:inputText id="pais" value="#{municipioMB.municipio.pais}" style=" width : 254px;" />
				
				<a4j:commandButton value="Gravar" action="#{municipioMB.merge}" styleClass="botoes" status="sts" reRender="municipios"/>
			</h:panelGrid>
			
			<a4j:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
		
	    </fieldset>
	</h:form>
</f:view>
</body>
</html>
