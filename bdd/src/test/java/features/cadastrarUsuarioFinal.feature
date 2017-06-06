#language: pt

Funcionalidade: Cadastrar um usuário no sistema de cadastro no sistema

  Narrativa: Eu como administrador do sistema posso cadastrar usuários na base do sistema.

  Cenário: Deve ser possível cadastrar um usuario no sistema de cadastros
    Dado que eu tenha o nome do usuário como "Assis Júnior" e o email como "assisjrs@gmail.com"
    Quando eu incluir o usuário no sistema
    Então Deve exibir 2 na lista
