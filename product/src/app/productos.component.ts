import { Component, resource } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent {

  titulo = 'Listado de productos';

  productos = resource({
    loader: async () => {
      const respuesta = await fetch('http://localhost:8080/product');
      if (!respuesta.ok) {
        throw new Error('Error al cargar los productos');
      }
      return (await respuesta.json()) as {
        id: number;
        name: string;
        price: number;
        category: string;
      }[];
    },
  });
}
