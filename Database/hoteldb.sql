--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    nfc_id character varying(20) NOT NULL,
    onoma character varying NOT NULL,
    eponimo character varying NOT NULL,
    hm_gennisis date NOT NULL,
    arithmos_eggrafou character varying NOT NULL,
    eidos_eggrafou character varying NOT NULL,
    arxi_ekdosis character varying NOT NULL,
    email character varying NOT NULL,
    phone character varying NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: cust_view; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.cust_view AS
 SELECT customer.nfc_id,
    customer.onoma,
    customer.eponimo,
    customer.hm_gennisis,
    customer.arithmos_eggrafou,
    customer.eidos_eggrafou,
    customer.arxi_ekdosis,
    customer.email,
    customer.phone
   FROM public.customer;


ALTER TABLE public.cust_view OWNER TO postgres;

--
-- Name: eggrafontai_se_ipiresies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eggrafontai_se_ipiresies (
    hm_ora_eggrafis date NOT NULL,
    nfc_id character varying(20) NOT NULL,
    id_ipiresias integer NOT NULL
);


ALTER TABLE public.eggrafontai_se_ipiresies OWNER TO postgres;

--
-- Name: episkeptontai; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.episkeptontai (
    hm_ora_eisodou timestamp without time zone NOT NULL,
    hm_ora_eksodou timestamp without time zone NOT NULL,
    nfc_id character varying(20) NOT NULL,
    id_xorou character varying NOT NULL
);


ALTER TABLE public.episkeptontai OWNER TO postgres;

--
-- Name: exoun_prosvasi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exoun_prosvasi (
    hm_ora_enarksis timestamp without time zone NOT NULL,
    hm_ora_liksis timestamp without time zone NOT NULL,
    nfc_id character varying(20) NOT NULL,
    id_xorou character varying NOT NULL
);


ALTER TABLE public.exoun_prosvasi OWNER TO postgres;

--
-- Name: ipiresies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ipiresies (
    id_ipiresias integer NOT NULL,
    perigrafi_ipiresias character varying NOT NULL,
    eggrafi character(1) NOT NULL
);


ALTER TABLE public.ipiresies OWNER TO postgres;

--
-- Name: nfc_idseq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nfc_idseq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nfc_idseq OWNER TO postgres;

--
-- Name: nfc_idseq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nfc_idseq OWNED BY public.customer.nfc_id;


--
-- Name: xreosi_ipiresias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.xreosi_ipiresias (
    perigrafi character varying NOT NULL,
    poso integer NOT NULL,
    nfc_id character varying(20) NOT NULL,
    id_ipiresias integer NOT NULL,
    hm_ora_xreosis timestamp without time zone
);


ALTER TABLE public.xreosi_ipiresias OWNER TO postgres;

--
-- Name: polisis_ana_katigoria; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.polisis_ana_katigoria AS
 SELECT ipiresies.perigrafi_ipiresias,
    x.counter
   FROM (( SELECT xreosi_ipiresias.id_ipiresias,
            count(*) AS counter
           FROM public.xreosi_ipiresias
          GROUP BY xreosi_ipiresias.id_ipiresias) x
     JOIN public.ipiresies USING (id_ipiresias));


ALTER TABLE public.polisis_ana_katigoria OWNER TO postgres;

--
-- Name: xoroi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.xoroi (
    id_xorou character varying NOT NULL,
    plithos_klinon integer NOT NULL,
    onomasia_xorou character varying NOT NULL,
    perigrafi_thesi_xorou character varying NOT NULL,
    id_ipiresias integer NOT NULL
);


ALTER TABLE public.xoroi OWNER TO postgres;

--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (nfc_id);


--
-- Name: ipiresies ipiresies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ipiresies
    ADD CONSTRAINT ipiresies_pkey PRIMARY KEY (id_ipiresias);


--
-- Name: xoroi xoroi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.xoroi
    ADD CONSTRAINT xoroi_pkey PRIMARY KEY (id_xorou);


--
-- Name: eggrafontai_se_ipiresies eggrafontai_se_ipiresies_id_ipiresias_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eggrafontai_se_ipiresies
    ADD CONSTRAINT eggrafontai_se_ipiresies_id_ipiresias_fkey FOREIGN KEY (id_ipiresias) REFERENCES public.ipiresies(id_ipiresias);


--
-- Name: eggrafontai_se_ipiresies eggrafontai_se_ipiresies_nfc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eggrafontai_se_ipiresies
    ADD CONSTRAINT eggrafontai_se_ipiresies_nfc_id_fkey FOREIGN KEY (nfc_id) REFERENCES public.customer(nfc_id);


--
-- Name: episkeptontai episkeptontai_id_xorou_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.episkeptontai
    ADD CONSTRAINT episkeptontai_id_xorou_fkey FOREIGN KEY (id_xorou) REFERENCES public.xoroi(id_xorou);


--
-- Name: episkeptontai episkeptontai_nfc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.episkeptontai
    ADD CONSTRAINT episkeptontai_nfc_id_fkey FOREIGN KEY (nfc_id) REFERENCES public.customer(nfc_id);


--
-- Name: exoun_prosvasi exoun_prosvasi_id_xorou_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exoun_prosvasi
    ADD CONSTRAINT exoun_prosvasi_id_xorou_fkey FOREIGN KEY (id_xorou) REFERENCES public.xoroi(id_xorou);


--
-- Name: exoun_prosvasi exoun_prosvasi_nfc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exoun_prosvasi
    ADD CONSTRAINT exoun_prosvasi_nfc_id_fkey FOREIGN KEY (nfc_id) REFERENCES public.customer(nfc_id);


--
-- Name: xoroi xoroi_id_ipiresias_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.xoroi
    ADD CONSTRAINT xoroi_id_ipiresias_fkey FOREIGN KEY (id_ipiresias) REFERENCES public.ipiresies(id_ipiresias);


--
-- Name: xreosi_ipiresias xreosi_ipiresias_id_ipiresias_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.xreosi_ipiresias
    ADD CONSTRAINT xreosi_ipiresias_id_ipiresias_fkey FOREIGN KEY (id_ipiresias) REFERENCES public.ipiresies(id_ipiresias);


--
-- Name: xreosi_ipiresias xreosi_ipiresias_nfc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.xreosi_ipiresias
    ADD CONSTRAINT xreosi_ipiresias_nfc_id_fkey FOREIGN KEY (nfc_id) REFERENCES public.customer(nfc_id);


--
-- PostgreSQL database dump complete
--

