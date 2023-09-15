import pyautogui
from time import sleep

sleep(2) #Tiempo para posicionar el mouse
while(True):
#for i in range(0,100):#(numInicial, numFinal)
    pyautogui.click()
    #sleep(2.6) #Tiempo muerto entre click y click
    
"""
#lo mismo de arriba pero en coords especificas de la pantalla
print(pyautogui.position())
for i in range(0,20):
    pyautogui.click(637,527) # <--- las coords especificas 
"""