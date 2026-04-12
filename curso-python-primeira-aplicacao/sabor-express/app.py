import os

def exibir_nome_do_programa():
    print('𝐒𝐚𝐛𝐨𝐫 𝐄𝐱𝐩𝐫𝐞𝐬𝐬\n')

    print('1. Cadastrar resturante')
    print('2. Listar resturante')
    print('3. Ativar resturante')
    print('4. Sair\n')

    # Se não colocarmos explicitamente o int, ela e salva como string
    # print(type(opcao_escolhida)) --> Sem o int(input()), será como str
    # print(type(1)) --> Resultará como int

def escolher_opcoes():
    opcao_escolhida = int(input('Escolha uma opção: '))
    print(f'Você escolheu a opção {opcao_escolhida}!')

def finalizar_app():
    #Realiza o fechamento do programa por uma biblioteca do Windows
    os.system('cls')
    print('Finalizando o app')

def exibir_opcoes():
    if opcao_escolhida == 1:
        print('Cadastrar restaurante:')

    elif opcao_escolhida == 2:
        print('Listando restaurante:')

    elif opcao_escolhida == 3:
        print('Ativando restaurante:')

    else:
        finalizar_app()

def main():
    exibir_nome_do_programa()
    exibir_opcoes()
    escolher_opcoes()

if __name__ == '__main__':
    main()