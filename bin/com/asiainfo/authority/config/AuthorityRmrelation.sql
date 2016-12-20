/** Effective config begin there   **/
--@JavaScript var AuthorityRmrelation = {};
--@JavaScript AuthorityRmrelation.query = {};
--@JavaScript AuthorityRmrelation.Add = {};
--@JavaScript AuthorityRmrelation.Update = {};
--@JavaScript AuthorityRmrelation.read = {};
--@JavaScript AuthorityRmrelation.Del = {};

--@JavaScript AuthorityRmrelation.Combobox = {};
--@JavaScript AuthorityRmrelation.Nest = {};
--@JavaScript AuthorityRmrelation.Export = {};

--@JavaScript AuthorityRmrelation.Query.query.SQL
select t1.N_RID     "n_rid",
       t1.N_MID     "n_mid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from AUTHORITY.AUTHORITY.T_AUTHORITY_rmrelation t1

/* tableData HQL   */ 
--@JavaScript AuthorityRmrelation.Query.query.HQL

--@JavaScript AuthorityRmrelation.Query.query.JPQL

-- AuthorityRmrelation.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityRmrelation.Read.read.SQL
select t1.N_RID     "n_rid",
       t1.N_MID     "n_mid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from AUTHORITY.AUTHORITY.T_AUTHORITY_rmrelation t1
  
-- AuthorityRmrelation.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityRmrelation.Read.read.HQL
-- AuthorityRmrelation.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityRmrelation t1 left outer join t1.NMparent p

--@JavaScript AuthorityRmrelation.Read.read.JPQL

-- SQL for select AuthorityRmrelation.Combobox.combobox.data
--@JavaScript AuthorityRmrelation.Combobox.combobox.SQL
select t1.N_RID     "n_rid",
       t1.N_MID     "n_mid"
  from AUTHORITY.AUTHORITY.T_AUTHORITY_rmrelation t1

--HQL select AuthorityRmrelation.Combobox.combobox.data
--@JavaScript AuthorityRmrelation.Combobox.combobox.HQL

--@JavaScript AuthorityRmrelation.Combobox.combobox.JPQL

--@JavaScript AuthorityRmrelation.Export.export.SQL
select t1.N_RID     "n_rid",
       t1.N_MID     "n_mid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from AUTHORITY.AUTHORITY.T_AUTHORITY_rmrelation t1

--@JavaScript AuthorityRmrelation.Export.export.HQL

--@JavaScript AuthorityRmrelation.Export.export.JPQL

--@JavaScript AuthorityRmrelation.Nest.nest.SQL
 
--@JavaScript AuthorityRmrelation.Nest.nest.HQL

--@JavaScript AuthorityRmrelation.Nest.nest.JPQL
