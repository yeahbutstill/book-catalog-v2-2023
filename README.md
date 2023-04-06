## Setup run container

```shell
docker run --rm \                              
--name book_catalog-db \
-e POSTGRES_DB=book_catalog \
-e POSTGRES_USER=subrutin \
-e POSTGRES_PASSWORD=subrutin \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/book_catalog-db-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres:15
```