begin;
ALTER TABLE xactivos ALTER COLUMN fecha_compra TYPE date;
alter table xactivos drop column fecha_depreciacion;
alter table activos  drop column fecha_depreciacion;
commit;
