Sistema de RH baseado no curso da DevSuperior de Microsserviços Java com Spring Boot adaptado para as versões Java 21 e Spring 3.2.5

Principais alterações:
  Java 11 -> 21
  Spring Boot 2.5.x -> 3.2.5
  Zuul -> Spring Cloud Gateway
  Ribbon -> Spring Cloud LoadBalancer
  Hystrix -> Spring Cloud Circuit Breaker (Resilience4J)

Autenticação utilizando o Spring Security 6 com chaves RSA no repositório de configuração conforme exemplo:

rsakeys.yaml
```
    jwt:
    public:
      key: |
        -----BEGIN PUBLIC KEY-----
        qweqweqweqweqweq
        -----END PUBLIC KEY-----
    private:
      key: |
        -----BEGIN PRIVATE KEY-----
        aaaaaaaaaaaaaaaaa
        -----END PRIVATE KEY-----
```


Geração de token jwt no endereço: 
```
http://localhost:8765/hr-oauth/login
```
        
