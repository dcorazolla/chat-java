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
		<a4j:keepAlive beanName="pessoaMB" />
		<h:messages/>
	
		 <fieldset>
	        <legend>Lista de Pessoas</legend>
			
			<rich:dataTable value="#{pessoaMB.pessoas}" var="pessoa" rows="10" id="pessoas" width="100%" cellspacing="0" cellpadding="0" border="1">
			
				<h:column>
					<f:facet name="header">
						<h:outputText value="NOME" />
					</f:facet>
					<h:outputText value="#{pessoa.nome}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="EMAIL" />
					</f:facet>
					<h:outputText value="#{pessoa.email}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="NASCIMENTO" />
					</f:facet>
					<h:outputText value="#{pessoa.nascimento}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="ENDERECO" />
					</f:facet>
					<h:outputText value="#{pessoa.logradouro}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="BAIRRO" />
					</f:facet>
					<h:outputText value="#{pessoa.bairro}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="CIDADE" />
					</f:facet>
					<h:outputText value="#{pessoa.municipio.nome}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="UF" />
					</f:facet>
					<h:outputText value="#{pessoa.municipio.uf}" />
				</h:column>
				
				<h:column>
					<a4j:commandLink reRender="panelGridInputs">
						<h:outputText value="Alterar"/>
						<f:setPropertyActionListener  value="#{pessoa}" target="#{pessoaMB.pessoa}"/>
					</a4j:commandLink>
				</h:column>
				
				<h:column>
					<a4j:commandLink action="#{pessoaMB.delete}" status="sts" reRender="pessoas">
						<h:outputText value="apagar"/>
						<f:setPropertyActionListener  value="#{pessoa.id}" target="#{pessoaMB.id}"/>
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
					<h:inputText id="nome" value="#{pessoaMB.pessoa.nome}" required="true" requiredMessage="Campo nome obrigatório!" styleClass="edit" size="40" />
					
					<h:outputLabel for="dataNasc" value="Data Nascimento (dd/mm/aaaa) "  />
					<h:inputText id="dataNasc" validatorMessage="Data de nascimento com formato inválido!" value="#{pessoaMB.pessoa.nascimento}" size="60" style=" width : 75px;">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:inputText> 

					<h:outputLabel for="email" value="Email " />
					<h:inputText id="email" value="#{pessoaMB.pessoa.email}" required="true" requiredMessage="Campo email obrigatório!" styleClass="edit" size="40" >
						<f:validator validatorId="emailValidator"/>
					</h:inputText>
					
					<h:outputLabel for="senha" value="Senha "  />
	     			<h:inputText id="senha" value="#{pessoaMB.pessoa.senha}" required="true" requiredMessage="Campo senha obrigatório!" size="30"/>
	     			
	     			<h:outputLabel for="endereco" value="Endereco "  />
					<h:inputText id="endereco" value="#{pessoaMB.pessoa.logradouro}" required="true" requiredMessage="Campo endereco obrigatório!" styleClass="edit" size="40" />
					
					<h:outputLabel for="complemento" value="Complemento "  />
					<h:inputText id="complemento" value="#{pessoaMB.pessoa.complemento}" styleClass="edit" size="40" />
					
					<h:outputLabel for="bairro" value="Bairro "  />
					<h:inputText id="bairro" value="#{pessoaMB.pessoa.bairro}" required="true" requiredMessage="Campo bairro obrigatório!" styleClass="edit" size="40" />
					
					<h:outputLabel for="cep" value="Cep "  />
					<h:inputText id="cep" value="#{pessoaMB.pessoa.cep}" required="true" requiredMessage="Campo cep obrigatório!" styleClass="edit" size="9" maxlength="9" />
					
					<h:outputLabel for="municipio" value="Municipio "  />
					<h:selectOneMenu id="municipio">
						<f:selectItems value="#{municipioMB.municipiosSelect}" />  
					</h:selectOneMenu>

								
				<a4j:commandButton value="Gravar" action="#{pessoaMB.merge}" styleClass="botoes" status="sts" reRender="pessoas"/>
			</h:panelGrid>
			<br>
			<a4j:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
		
	    </fieldset>
	</h:form>
</f:view>
</body>
</html>
