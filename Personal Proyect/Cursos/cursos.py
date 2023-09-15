import pyautogui
import clipboard
from time import sleep

#Abrir navegador
pyautogui.press('win')
pyautogui.write('brave')
pyautogui.press('enter')

primeraVez = True
cursosSinReclamar = 0
cursosReclamados = 0

sleep(1)
#se repite por cada link cargado
with open("links.txt", "r", encoding='utf-8') as file:
    for url in file:
        if(url[0:21] == "https://www.udemy.com"):
                if(not primeraVez):
                        pyautogui.press('f6')
                #Busca el link
                primeraVez = False
                pyautogui.write(url)
                pyautogui.press('enter')
                sleep(3)

                #Selecciona el precio
                pyautogui.moveTo(946, 438)
                sleep(0.5)
                pyautogui.click()
                pyautogui.click()

                with pyautogui.hold('ctrl'):
                        pyautogui.press('c')
                
                #Guarda el precio flitrando la palabra "actual"
                precio = clipboard.paste()
                precioDefinitivo = precio[6:]
                
                if(precioDefinitivo == "Gratis"):
                        pyautogui.click(1044,605)
                        sleep(3)
                        pyautogui.click(981,520)
                        cursosReclamados +=1
                        sleep(2)
                else:
                        cursosSinReclamar+=1
                        
print("Cursos reclamados ", cursosReclamados, " \ncursos sin reclamar ", cursosSinReclamar)
        