# API PickUp

API PickUp

## Requerimientos

jdk version 1.8
maven 3.6.3

## Installation

Clonar el repositorio de git https://github.com/crisflores/API-PickUp .
```bash
git clone https://github.com/crisflores/API-PickUp´
```

## Compilacion

```bash
mvn install
```

## Ejecucion

```bash
mvn spring-boot:run
```

## Usage
```url
localhost:8080/getSucursal
```
Metodo POST


```javascript
Request

{
    "latitud":Integer,
    "longuitud":Integer
}

Response

{
    "id": Integer,
    "direccion": String,
    "longuitud": Integer,
    "latitud": Integer
}

Ejemplo
{
  "longuitud": 1,
  "latitud": 10
}


descripcion: calcula la distancia lineal desde
la ubicacion dada hasta la sucursal mas cerca

```


```url
localhost:8080/createSucursal
```

```javascript
Request

{
    "id": Integer,
    "direccion": String,
    "longuitud": Interger,
    "latitud": Integer
}

Response

{
    "id": Integer,
    "direccion": String,
    "longuitud": Integer,
    "latitud": Integer
}

Ejemplo
{
    "id": 2,
    "direccion": "papa francisco 879",
    "longuitud": 1,
    "latitud": 10
}

descripcion: crea una sucursal en base de datos

```

```url
localhost:8080/buscarSucursal
```

```javascript
Request

{
    "id": Integer
}

Response

{
    "id": Integer,
    "direccion": String,
    "longuitud": Integer,
    "latitud": Integer
}

Ejemplo
{
    "id": 2
}

descripcion: busca una sucursal por numero de id

```