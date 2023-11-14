import tkinter as tk
from tkinter import messagebox
import yt_dlp

# Crear la ventana principal
root = tk.Tk()
root.withdraw()  # Ocultar la ventana principal

try:
    with open("links.txt", "r", encoding='utf-8') as file:
        for url in file:
            ydl_opts = {}
            with yt_dlp.YoutubeDL(ydl_opts) as ydl:
                ydl.download([url])
            messagebox.showinfo("Exito", f"Archivo descargado con exito")
except Exception as e:
    messagebox.showinfo("Error", f"Ocurrió un error, Error: {e}")
