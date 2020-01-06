#   OBK-BACKEND-CARDS

Microsserviço para consumo de APIs do domínio de Cartões
 
 
## Build
 
Para efetuar o build da aplicação, execute o comando abaixo, no terminal.  

```
$ mvn clean install  
```

## Variáveis
 
Variáveis para o Openshift
 
```OBK_BACKEND_CARDS

OBK_BACKEND_CARDS_HUB_URL=
OBK_BACKEND_CARDS_LOG_LEVEL = Nível do log ex.: INFO, ERROR, DEBUG
OBK_BACKEND_CARDS_PORT= Porta do serviço Ex.: 8080.
OBK_BACKEND_CARDS_HUBSIGNATURE = Caminho para certificado.
OBK_BACKEND_CARDS_PERSONAS_PRODUTOATIVO_PATH=/people/v2/contracts/by-active-product
OBK_BACKEND_CARDS_SIGNATUREAUTHENTICATION_PATH=/system-security/v2/signature-authentication
OBK_BACKEND_CARDS_PERSONAS_CODIGOCLIENTE_PATH=/people/v2/person-code/by-document-number
OBK_BACKEND_CARDS_RETRIEVES_SALES_CHANNEL_DATA_PATH=/card-acquisition-proposal/v1/check-sales-channel/{clientId}
OBK_BACKEND_CARDS_RETRIEVES_REQUEST_TOKEN_DATA_PATH=/card-acquisition/v2/proposals/request-challenge
OBK_BACKEND_CARDS_UPDATE_PROPOSAL_EXTERNAL_BUREAU_CREDIT_PATH=/risks/v1/external-beureau/early-check
OBK_BACKEND_CARDS_VALIDATE_EMAIL_PATH=/card-acquisition/v2/proposals/risk/validate-email
OBK_BACKEND_CARDS_UPDATE_PROPOSAL_CAREER_PATH=/card-acquisition-proposal/v1/save-career
OBK_BACKEND_CARDS_UPDATE_PROPOSAL_ROOT_PATH=/card-acquisition/v2/proposals/update
OBK_BACKEND_CARDS_CREATE_PROPOSAL_NCC_PATH=/card-acquisition/v2/proposals
OBK_BACKEND_CARDS_CREATE_PROPOSAL_RISK_ANALYSIS_PATH=/card-acquisition/v2/proposals/risk/check
OBK_BACKEND_CARDS_UPDATE_PROPOSAL_PARTNER_SALES_PATH=/card-acquisition-proposal/v1/save-partner
OBK_BACKEND_CARDS_VALIDATE_CMA_PATH=/card-acquisition/v2/proposals/risk/validate-cma
OBK_BACKEND_CARDS_HUBAPIKEY= HUB api key

```

## DDL

É necessário criar os objetos no banco de dados antes de executar
o serviço.

Os arquivos estão disponiveis na pasta:

- **cql**


## Support Driver

- Cassandra