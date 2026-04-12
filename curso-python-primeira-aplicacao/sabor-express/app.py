import os

restaurantes = ['Pizza', 'Cebola']

def exibir_nome_do_programa():
    print('𝐒𝐚𝐛𝐨𝐫 𝐄𝐱𝐩𝐫𝐞𝐬𝐬\n')

    print('1. Cadastrar resturante')
    print('2. Listar resturante')
    print('3. Ativar resturante')
    print('4. Sair\n')

    # Se não colocarmos explicitamente o int, ela e salva como string
    # print(type(opcao_escolhida)) --> Sem o int(input()), será como str
    # print(type(1)) --> Resultará como int

def cadastrar_novo_restaurante():
    exibir_substitulo('Cadastro de novos restaurantes\n')
    
    nome_do_restaurante = input('Digite o nome do restaurante que deve ser cadastrado: ')
    restaurantes.append(nome_do_restaurante)
    print(f'O restaurante {nome_do_restaurante} foi cadastrado com sucesso!')

    voltar_ao_menu_principal()

def listar_restaurantes():
    exibir_substitulo('Listando os restaurantes\n')

    for restaurante in restaurantes:
        print(restaurante)

    voltar_ao_menu_principal()

def escolher_opcoes():
    try: 
        opcao_escolhida = int(input('Escolha uma opção: '))
        print(f'Você escolheu a opção {opcao_escolhida}!')

        if opcao_escolhida == 1:
            cadastrar_novo_restaurante()

        elif opcao_escolhida == 2:
            listar_restaurantes()

        elif opcao_escolhida == 3:
            print('Ativando restaurante:')

        elif opcao_escolhida == 4:
            finalizar_app()

        else:
            opcao_invalida()

    except:
        opcao_invalida()

def finalizar_app():
    #Realiza o fechamento do programa por uma biblioteca do Windows
    exibir_substitulo('Finalizando o app')

def voltar_ao_menu_principal():
    input('Digite uma tecla pra voltar ao menu principal\n')
    main()

def opcao_invalida():
    print('Opção invalida!')
    voltar_ao_menu_principal()

def exibir_substitulo(texto):
    os.system('cls')
    print(texto)

def main():
    exibir_nome_do_programa()
    escolher_opcoes()

if __name__ == '__main__':
    main()