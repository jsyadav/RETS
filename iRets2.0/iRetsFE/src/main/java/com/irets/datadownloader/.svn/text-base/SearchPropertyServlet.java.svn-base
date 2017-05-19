package com.irets.datadownloader;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ui.irets.service.JAXBHelper;
import ui.irets.service.JacksonJSONHelper;
import ui.irets.service.unifiedsr.Filter;
import ui.irets.service.unifiedsr.FilterItem;
import ui.irets.service.unifiedsr.GeoParameter;
import ui.irets.service.unifiedsr.SimpleRange;

import com.irets.bl.service.ExteriorFeaturesData;
import com.irets.bl.service.SearchService;
import com.irets.exception.LargeResultSetException;
import com.irets.generated.Errors;
import com.irets.generated.Properties;
import com.irets.logging.domain.AppLogger;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Nov 15, 2010
 * Time: 1:02:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchPropertyServlet  extends HttpServlet {
	
	AppLogger log = AppLogger.getLogger(SearchPropertyServlet.class);
	
	// Hack, mapping from the short name (CityID) to long name.
	public static String[] cityID={"APT","AR","AT","BEL","BRI","BUR","CA","CAP","CAR","CV","COL","CU","DC","DR","EP","SZE","ELG","FC","GY","HMB","HIL","HO","LH","LVO","LM","LA","LAH","LG","LGM","MA","MP","MIL","MI","MON","MS","MO","MH","MOS","MV","NOM","NOC","PG","PAC","PA","PB","PES","PV","RC","RS","RIO","SS","SMH","SB","SCL","SGR","SJ","SJB","SLV","MR","SM","SC","SZ","SA","SV","SCF","SOQ","SCT","SOM","SOC","SSF","SU","TP","WA","SZW","WOD","ALA","ALB","BER","CAS","DUB","EMR","HAY","LVM","NWK","FRE","OAK","PDM","PLE","SLD","SLZ","SUN","UC","ALO","ANT","BPT","BBK","BLK","BRE","CLA","CON","CRO","DAN","DIA","DBY","ELC","ELS","HER","KEN","LAF","MTZ","MOR","OKY","ORI","PIN","PIT","PLH","RIC","ROD","ROS","SNP","SNR","WAL","SF","UN","OC","YBA","WMN","VVL","VNT","VLJ","VCV","TWH","TST","TRL","TRK","TRC","TRN","TOK","STK","SRA","SNM","SIM","SMD","SSS","SOA","SEA","SLB","SLT","SRS","SMN","SMR","SCR","SRF","MAR","SLO","SAN","CLM","BRN","ANS","SDA","SAC","RVL","RNP","RCK","RPN","RSQ","RDB","RBF","RSM","RSF","RCV","PDR","PVL","PSM","PLM","PTN","PAS","PRD","PVP","PMS","ORV","ORG","OJI","OKD","NVT","NRG","NPB","NAP","MRT","MTR","MDS","MVJ","MLV","MER","MDR","MNC","MTB","MLB","LBN","LAX","LMS","LGB","LCN","LRK","LNB","LPM","LMA","LJL","IRV","HTG","HBR","HCH","GRB","KNT","GNB","GDL","GGV","FUL","FSN","FFD","FLS","FRO","EXR","URK","SCN","EKG","EDH","DXN","DMR","DVS","CVN","CDM","CGD","CVS","CVD","CHT","CVT","CRS","CMK","CBD","CMN","CMB","BRA","BRD","BSC","BNC","BTB","ABR","AWR","ASC","AYG","ANL","AGC","AMC","AVJ","ALH","AGH","LGM","ES","NS","RDG","MAD","CER","CFA","CLS","CWD","CUL","ELO","ENS","HRB","JAS","LCR","LOD","MUR","NEV","NFK","OCN","PEN","PLC","RIA","AAA","SNB","SOU","SRC","UPN","VOL","WLT","WSC","WLN","WTR","WDH","RSD","GRV","PGV","CRN","CM","PD","CMP","VAL","MOT","RVB","YB","EST","AVL","LAA","YUV","LHB","KKW","MKV","PIO","ACY","DYT","FID","KCA","MTL","PLY","RPI","ION","JAC","PIG","PNR","SIL","BAG","BCR","CMI","FFL","FBT","FOR","MAG","NEL","PAM","RCL","STY","BIG","CHC","DUH","GRI","OVE","THL","ATL","AVY","BRS","CSC","DFL","GCO","HPI","MKH","MCH","RRF","SRH","VCO","WLC","WLY","ARN","CMC","SAA","VAS","WPO","GME","PPN","SFD","ARB","COU","MAX","WIL","FDI","GQT","KMH","CRY","STR","COO","CCL","ECL","EDR","GVA","GNW","GZF","LTS","MAU","PIL","SST","TAH","TWB","BIJ","DIS","GEO","KYB","POL","STA","STL","TAV","AUB","BCK","BRR","CAK","DRY","DLP","FPO","FNT","HLM","HMU","LSR","LTN","MHS","PIE","PHR","RAI","SVL","SQL","THS","TRQ","BIO","CAW","CTS","CNV","CGA","EAT","FIR","FOW","HUR","KER","KGB","MED","OCO","PAL","PDL","REE","RIR","SJO","SER","SEL","ARO","BCY","ECR","GNN","HAC","ORL","WWS","ALD","BSD","BBG","BGE","CRA","CTE","FLA","HDW","HPA","KND","KRL","MDA","MYF","ORE","PET","PHP","RCT","SAM","TDD","WET","WHH","ART","BLA","FER","FOT","GBV","HYD","LOL","MCK","ORK","REW","RID","SCO","WHV","WCR","BDR","IRL","OTL","PVR","BRW","CAX","CAT","ECE","HEB","HOV","NIL","SCI","SEE","THR","WML","WTH","DWN","DVA","KEE","LLK","OLA","SSN","TPA","BIP","BIS","IND","LPI","BSH","CAN","EDI","EDW","FEL","GVL","JOH","KNE","LBC","LHI","MCF","MKI","ONY","RBG","TUP","WDY","ARV","BAL","BOR","BWL","CAF","CNL","DEL","DLK","FRP","FRV","GOM","GAC","HCC","INY","KRV","LAI","LAM","MCA","MOJ","NOE","OIL","PUM","RIG","RMD","SHA","TAF","THE","WAC","WEL","WOF","KTY","ARM","AVE","CRC","HAN","LEM","STF","CLK","CBB","FLY","GHN","HVL","WGS","CLO","CLP","KEL","LAK","LLA","LUC","MID","NIC","UPL","BBR","DOY","HLG","JVL","LIT","MDE","MCR","MFD","NUB","RVN","SDH","TMO","WNL","SNV","WSW","CMT","LCF","LHU","MWI","MBY","NHL","SFE","SVH","SNL","UCY","VVI","VYO","VCY","WHL","WLM","WKA","ACT","ATA","ARD","ARL","ASA","AVA","AZU","BAP","BLL","BEG","BEF","BEH","BRB","BNK","CLB","CNP","CCY","CSN","CTC","COA","CHW","CCO","CIN","CPT","CUD","DIB","DOW","DUA","ERO","ELA","ECP","EMN","ENC","GDA","GLE","GRH","HAR","HAG","HAW","HID","HOW","ING","IRW","LCA","LMI","LPU","LVE","LWD","LAN","LAW","LEN","LTR","LLN","LTA","LNI","LYN","MAV","MAY","MTC","MIH","MRV","MOP","NEH","NHW","NRW","PAP","PAO","PVE","PNC","PAR","PDA","PEA","PIR","POM","QUH","RPV","RPA","ROH","RHE","ROM","RHI","SAD","SAG","SMA","SPE","SFS","SAU","SEP","SIH","SLL","SGA","SPA","STU","SYL","TAR","TMC","TEI","TOL","TOP","TUJ","VAN","VEN","VER","WAP","WAS","WCO","WHO","WLA","WES","WVI","WHI","AHW","ONE","RAD","WSN","BAV","CWC","OKH","BAS","DLB","FKN","IVN","LGS","MAH","NSO","OLE","PRS","SGE","SQU","TMS","BEV","CMA","FAI","KWD","MAC","RSS","SVE","STB","SBP","TIB","WOO","CTV","FCA","Hos","YNP","CVE","EPO","MRP","MIP","BNB","CPR","CCH","DRS","ELK","LGT","LRV","MAN","NAV","PRY","POA","RVA","WPT","YKV","ALN","BOO","CAL","CVL","FOB","GUL","HOP","LAY","MEN","PHI","POV","TAL","UKI","WIT","BAC","CSY","ENO","HMR","SRP","SNE","SDP","SVN","DEH","DOP","GUS","LEG","LIV","PLA","WTN","ADI","CBY","DVC","EAG","FBI","LCI","LKY","LKT","ATR","CDV","BTN","LVI","TPZ","BSP","BRG","CLL","JUN","MAM","PPY","SHE","ANG","CAG","DEE","OVL","RUT","YOU","CRI","CPK","FLN","NDN","NSJ","RAR","SMT","SOS","WSH","AH","ATW","EIV","FHR","FVA","LDR","LFO","NWC","SSD","ANA","BUN","CBE","COH","CYP","DAP","ELT","LAG","LNG","LGW","LAL","MIC","SJC","SDO","SLA","SNN","SBS","TRA","VIP","ALT","DUT","EGA","GRU","HWD","OLY","PNN","SDN","ALR","APP","CBA","CHE","LKA","FOH","KIB","MEV","NEW","TAC","THV","WEI","BEC","BDN","BGA","CYD","COT","CLI","CRM","GNV","MVY","SRI","TAY","TWA","VTN","EQU","GRA","OLL","POT","QUI","WWD","AGU","CCA","DSC","HLD","MAB","MNF","MOY","MCE","NPS","NUE","TPS","WWA","WLD","WCH","ANZ","BAN","BEA","BLY","CAB","CAM","CCT","CVA","DHS","EMO","EAS","HEM","IDY","INW","INI","LQU","LAE","MEC","MRL","NOR","PDE","PER","RMI","RIS","RUB","SAJ","SUY","SYS","TEM","TML","CRT","HRD","HOO","MHR","MCN","RSA","RYD","SLH","ELV","GAL","ISL","NHI","RIL","WAG","AMB","ANO","BYM","CGN","CNK","CIA","CRR","ERP","ESS","FFA","FWN","GVK","GTI","HND","JTR","LDS","LDW","LCK","MPS","NTN","PKD","PAT","RMN","RFM","SKY","SGL","TWP","VID","YCP","ADE","APV","ARG","BAK","BAM","BAR","BBC","BBL","BLO","BLU","BLH","CHO","CHH","CLT","CRE","DAG","FAW","FON","GTE","HES","HGH","HIN","HOD","LKH","LML","LUV","MET","MOC","MVA","MUS","NEE","NES","ONT","ODE","PHE","PIH","PEE","RAN","RED","RSP","TRO","TPE","WRW","YER","BVD","CPN","CPO","CDS","DUZ","GUT","JMA","MLA","PAA","PNV","PTR","RCA","SLR","SYB","SPV","TEC","WSP","ALP","BON","BSL","BOS","COD","DES","ECA","ESC","FAL","IMP","JAM","JUL","LKS","LMG","LEU","LIA","NAT","OBE","PAB","PMO","PAU","POW","RAM","SYD","STE","VAC","VIT","CMS","FMN","FCP","HLT","VNL","VIC","WGE","ACA","LAT","LIN","LOC","THO","CTN","GVB","HMY","SSI","SHN","AVI","BAW","CYC","LOS","MBA","NIP","OCE","SMI","SGT","SHB","TMP","CAA","LAS","LOV","BUE","CNT","GOL","GUA","IVI","LMC","MOO","NEC","ORC","SBA","SYN","SOV","SUM","ALL","CPE","GYB","SRY","DON","LOY","SIV","CHN","FOS","FJO","GZL","GVW","GNA","HBK","KHV","MDL","SCB","SEV","SMB","DOR","DUS","ETN","HAP","MCC","MGU","MSH","TLL","WEE","YRE","BLG","EMA","TAB","RIV","SUC","ANN","BDA","BBY","CKR","CZD","DNM","EVE","EGE","FTN","GYV","JNN","OCC","SPO","TSR","VFR","VGR","VBG","BHS","CTI","FOV","GEL","GTN","GUE","KNW","MNR","RIN","SEB","WIN","CDG","HKM","LGR","DEN","EMP","HUG","KEY","NEM","WAT","WEY","MRD","NLS","PGR","RSO","ROB","STT","FLO","Mtn","MLK","MNL","PSK","PYC","PBA","TMA","VNA","CRG","GER","LMO","BGR","BTR","DGC","HYM","JCY","MRR","SAL","TNR","ZEN","HFK","LWS","WEA","BAD","CHS","CNS","DUC","KHW","KCP","LCO","PSY","SQA","SNA","TRV","WKN","YTM","ALG","CCR","CUT","DIN","EAR","FAR","GOS","IVA","LDY","ORO","PIX","POR","RGV","SPG","STH","TEB","TRI","TIP","TUL","VIS","WDL","BOF","DDL","MWV","MSN","PCT","SVY","STD","SWB","CCP","COB","GLD","LBA","TUO","BDS","OAP","OAV","PMN","PHC","SIS","CML","CSP","FIL","MRK","NEP","OXN","PIU","POH","SAP","WVL","Bks","CPY","CBG","DGN","GUN","MAI","RUM","Ylo","ZAM","BRC","BRY","ESP","KNL","WDD","BLE","BRV","BSV","CPV","CGE","DOB","ORH","RAC","SWV","MRY","OLI","WHE","AAH","AMN","BTE","CHI","FLM","HUN","MME","SVA","THK","MNT","KNF","MRA","VLH","STN","EAC","LNA","277","4094","4013","362"};	
	public static String[] cityName={"Aptos","Aromas","Atherton","Belmont","Brisbane","Burlingame","Campbell","Capitola","Carmel","Carmel Valley","Colma","Cupertino","Daly City","Del Rey Oaks","East Palo Alto","East Santa Cruz County","El Granada","Foster City","Gilroy","Half Moon Bay","Hillsborough","Hollister","La Honda","Live Oak","Loma Mar","Los Altos","Los Altos Hills","Los Gatos","Los Gatos Mtns","Marina/Former Fort Ord","Menlo Park","Millbrae","Milpitas","Montara","Monte Sereno","Monterey","Morgan Hill","Moss Beach","Mountain View","North Monterey County","North San Benito County","Pacific Grove","Pacifica","Palo Alto","Pebble Beach","Pescadero","Portola Valley","Redwood City","Redwood Shores","Rio Del Mar / Seascape","South Salinas","Salinas Monterey Highway","San Bruno","San Carlos","San Gregorio","San Jose","San Juan Bautista","San Lorenzo Valley","San Martin","San Mateo","Santa Clara","Santa Cruz","Saratoga","Scotts Valley","Seacliff","Soquel","South Coast","South Monterey County","South San Benito County","South San Francisco","Sunnyvale","Tres Pinos","Watsonville","West Santa Cruz County","Woodside","Alameda","Albany","Berkeley","Castro Valley","Dublin","Emeryville","Hayward","Livermore","Newark","Fremont","Oakland","Piedmont","Pleasanton","San Leandro","San Lorenzo","Sunol","Union City","Alamo","Antioch","Bay Point","Bethel Island/Byron/Knightsen","Blackhawk","Brentwood","Clayton","Concord/Clyde","Crockett/Port Costa","Danville","Diablo","Discovery Bay","El Cerrito","El Sobrante","Hercules","Kensington","Lafayette","Martinez/Pacheco","Moraga/Canyon","Oakley","Orinda","Pinole","Pittsburg","Pleasant Hill","Richmond","Rodeo","Rossmoor","San Pablo","San Ramon","Walnut Creek","San Francisco County","Unincorporated","Other City","Yuba City","Westminster","Victorville","Ventura","Vallejo","Vacaville","Twain Harte","Tustin","Turlock","Truckee","Tracy","Torrance","Thousand Oaks","Stockton","Sonora","Sonoma","Simi Valley","Sierra Madre","Shingle Springs","Sherman Oaks","Seaside/Former Fort Ord/Sand City","Seal Beach","Sausalito","Santa Rosa","Santa Monica","Santa Maria","Santa Clarita","San Rafael","San Marcos","San Luis Obispo","San Diego","San Clemente","San Bernardino","San Anselmo","Salida","Sacramento","Roseville","Rohnert Park","Rocklin","Ripon","Rescue","Redondo Beach","Red Bluff","Rancho Santa Margarita","Rancho Santa Fe","Rancho Cordova","Playa Del Rey","Placerville","Pismo Beach","Petaluma","Patterson","Paso Robles","Paradise","Palos Verdes Peninsula","Palm Springs","Orangevale","Orange","Ojai","Oakdale","Novato","Northridge","Newport Beach","Napa","Murrieta","Montrose","Modesto","Mission Viejo","Mill Valley","Merced","Marina Del Rey","Manteca","Manhattan Beach","Malibu","Los Banos","Los Angeles","Loomis","Long Beach","Lincoln","Larkspur","Laguna Beach","La Palma","La Mesa","La Jolla","Irvine","Huntington Beach","Healdsburg","Hacienda Heights","Greenbrae","Kentfield","Granite Bay","Glendale","Garden Grove","Fullerton","Fresno","Fairfield","Folsom","Fair Oaks","Exeter","Eureka","Escalon","Elk Grove","El Dorado Hills","Dixon","Del Mar","Davis","Covina","Corona Del Mar","Coarsegold","Clovis","Cloverdale","Citrus Heights","Chula Vista","Ceres","Carmichael","Carlsbad","Camino","Cambria","Brea","Bradley","Big Sur Coast","Benicia","Belvedere Tiburon","Auburn","Atwater","Atascadero","Arroyo Grande","Antelope","Angels Camp","American Canyon","Aliso Viejo","Alhambra","Agoura Hills","Los Gatos Mtns SCZ","East Salinas","North Salinas","Ridgemark","Madera","Cerritos","Colfax","Copperopolis","Cottonwood","Culver City","El Segundo","Encinitas","Hermosa Beach","Jamestown","La Crescenta","Lodi","Murphys","Nevada City","North Fork","Oceanside","Penn Valley","Placentia","Rialto","Santa Ana","Solana Beach","South El Monte","Sutter Creek","Upland","Volcano","Walnut","West Sacramento","Wilton","Winters","Woodland Hills","Reseda","Grass Valley","Penngrove","Corona","Costa Mesa","Palmdale","Cameron Park","Valencia","Montebello","Riverbank","Yorba Linda","East of Highway 17","Adult Village","Lake Arrowhead","Yucca Valley","La Habra","Kirkwood","Markleeville","Pioneer","Amador City","Drytown","Fiddletown","Kit Carson","Martell","Plymouth","River Pines","Ione","Jackson","Pine Grove","Pioneer","Silver Lake","Bangor","Berry Creek","Clipper Mills","Feather Falls","Forbestown","Forest Ranch","Magalia","Nelson","Palermo","Richvale","Stirling City","Biggs","Chico","Durham","Gridley","Oroville","Thermalito","Altaville","Avery","Burson","Campo Seco","Douglas Flat","Glencoe","Hathaway Pines","Mokelumne Hill","Mountain Ranch","Rail Road Flat","Sheep Ranch","Vallecito","Wallace","Wilseyville","Arnold","Camp Connell","San Andreas","Valley Springs","West Point","Grimes","Princeton","Stonyford","Arbuckle","Colusa","Maxwell","Williams","Fort Dick","Gasquet","Klamath","Crescent City","Smith River","Coloma","Cool","Echo Lake","El Dorado","Garden Valley","Greenwood","Grizzly Flats","Lotus","Mount Aukum","Pilot Hill","Somerset","Tahoma","Twin Bridges","Bijou","Diamond Springs","Georgetown","Kyburz","Pollock Pines","South Lake Tahoe","Stateline","Tahoe Valley","Auberry","Big Creek","Burrel","Cantua Creek","Del Rey","Dunlap","Five Points","Friant","Helm","Hume","Lakeshore","Laton","Mono Hot Springs","Piedra","Prather","Raisin","Shaver Lake","Squaw Valley","Tollhouse","Tranquillity","Biola","Calwa","Caruthers","Centerville","Coalinga","Easton","Firebaugh","Fowler","Huron","Kerman","Kingsburg","Mendota","Orange Cove","Parlier","Pinedale","Reedley","Riverdale","San Joaquin","Sanger","Selma","Artois","Butte City","Elk Creek","Glenn","Hamilton City","Orland","Willows","Alderpoint","Bayside","Blocksburg","Bridgeville","Carlotta","Cutten","Fields Landing","Honeydew","Hoopa","Kneeland","Korbel","Miranda","Myers Flat","Orleans","Petrolia","Phillipsville","Redcrest","Samoa","Trinidad","Weott","Whitethorn","Arcata","Blue Lake","Ferndale","Fortuna","Garberville","Hydesville","Loleta","McKinleyville","Orick","Redway","Rio Dell","Scotia","Westhaven","Willow Creek","Bard","Imperial","Ocotillo","Palo Verde","Brawley","Calexico","Calipatria","El Centro","Heber","Holtville","Niland","Salton City","Seeley","Thermal","Westmorland","Winterhaven","Darwin","Death Valley","Keeler","Little Lake","Olancha","Shoshon","Tecopa","Big Pine","Bishop","Independence","Lone Pine","Bodfish","Caliente","Edison","Edwards","Fellows","Glennville","Johannesburg","Keene","Lebec","Lost Hills","Mc Farland","Mc Kittrick","Onyx","Randsburg","Tupman","Woody","Arvin","Bakersfield","Boron","Buttonwillow","California City","Cantil","Delano","Desert Lake","Frazier Park","Fremont Valley","Gorman","Greenacres","Hillcrest Center","Inyokern","Kernville","Lake Isabella","Lamont","Maricopa","Mojave","North Edwards","Oildale","Pumpkin Center","Ridgecrest","Rosamond","Shafter","Taft","Tehachapi","Wasco","Weldon","Wofford Heights","Kettleman City","Armona","Avenal","Corcoran","Hanford","Lemoore","Stratford","Clearlake","Cobb","Finley","Glenhaven","Hidden Valley Lake","Witter Springs","Clearlake Oaks","Clearlake Park","Kelseyville","Lakeport","Lower Lake","Lucerne","Middletown","Nice","Upper Lake","Bieber","Doyle","Herlong","Janesville","Litchfield","Madeline","Mcarthur","Milford","Nubieber","Ravendale","Standish","Termo","Wendel","Susanville","Westwood","Claremont","La Canada Flintridge","Lake Hughes","Mount Wilson","Mt Baldy","North Hills","San Fernando","Stevenson Ranch","Sunland","Universal City","Valley Village","Valyermo","Verdugo City","West Hills","Wilmington","Winnetka","Acton","Altadena","Arcadia","Arleta","Artesia","Avalon","Azusa","Baldwin Park","Bell","Bell Gardens","Bellflower","Beverly Hills","Bradbury","Burbank","Calabasas","Canoga Park","Canyon Country","Carson","Castaic","Charter Oak","Chatsworth","City of Commerce","City of Industry","Compton","Cudahy","Diamond Bar","Downey","Duarte","Eagle Rock","East Los Angeles","Echo Park","El Monte","Encino","Gardena","Glendora","Granada Hills","Harbor City","Hawaiian Gardens","Hawthorne","Hidden Hills","Hollywood","Inglewood","Irwindale","La Canada","La Mirada","La Puente","La Verne","Lakewood","Lancaster","Lawndale","Lennox","Littlerock","Llano","Lomita","Los Nietos","Lynwood","Mar Vista","Maywood","Mint Canyon","Mission Hills","Monrovia","Monterey Park","Newhall","North Hollywood","Norwalk","Pacific Palisades","Pacoima","Palos Verdes Estates","Panorama City","Paramount","Pasadena","Pearblossom","Pico Rivera","Pomona","Quartz Hill","Rancho Palos Verdes","Rancho Park","Rolling Hills","Rolling Hills Estates","Rosemead","Rowland Heights","San Dimas","San Gabriel","San Marino","San Pedro","Santa Fe Springs","Saugus","Sepulveda","Signal Hill","Silver Lake","South Gate","South Pasadena","Studio City","Sylmar","Tarzana","Temple City","Terminal Island","Toluca Lake","Topanga","Tujunga","Van Nuys","Venice","Vernon","Walnut Park","Watts","West Covina","West Hollywood","West Los Angeles","Westchester","Westlake Village","Whittier","Ahwahnee","O Neals","Raymond","Wishon","Bass Lake","Chowchilla","Oakhurst","Bolinas","Dillon Beach","Forest Knolls","Inverness","Lagunitas","Marshall","Nicasio","Olema","Point Reyes Station","San Geronimo","San Quentin","Tomales","Belvedere","Corte Madera","Fairfax","Kent Woodlands","Marin City","Ross","Santa Venetia","Stinson Beach","Strawberry Point","Tiburon","Woodacre","Catheys Valley","Fish Camp","Hornitos","Yosemite National Park","Coulterville","El Portal","Mariposa","Midpines","Branscomb","Caspar","Comptche","Dos Rios","Elk","Leggett","Littleriver","Manchester","Navarro","Piercy","Point Arena","Redwood Valley","Westport","Yorkville","Albion","Boonville","Calpella","Covelo","Fort Bragg","Gualala","Hopland","Laytonville","Mendocino","Philo","Potter Valley","Talmage","Ukiah","Willits","Ballico","Cressey","El Nido","Hilmar","Santa Rita Park","Snelling","South Dos Palos","Stevinson","Delhi","Dos Palos","Gustine","Le Grand","Livingston","Planada","Winton","Adin","Canby","Davis Creek","Eagleville","Fort Bidwell","Lake City","Likely","Lookout","Alturas","Cedarville","Benton","Lee Vining","Topaz","Bishop","Bridgeport","Coleville","June Lake","Mammoth Lakes","Pope Valley","Saint Helena","Angwin","Calistoga","Deer Park","Oakville","Rutherford","Yountville","Cedar Ridge","Chicago Park","Floriston","Norden","North San Juan","Rough And Ready","Smartville","Soda Springs","Washington","Alta Hill","Atwood","East Irvine","Foothill Ranch","Fountain Valley","Ladera Ranch","Lake Forest","Newport Coast","Surfside","Anaheim","Buena Park","Capistrano Beach","Cowan Heights","Cypress","Dana Point","El Toro","Laguna Hills","Laguna Niguel","Laguna Woods","Los Alamitos","Midway City","San Juan Capistrano","Silverado","South Laguna","Stanton","Sunset Beach","Trabuco Canyon","Villa Park","Alta","Dutch Flat","Emigrant Gap","Gold Run","Homewood","Olympic Valley","Penryn","Sheridan","Almanor","Applegate","Carnelian Bay","Chester","Lake Almanor","Foresthill","Kings Beach","Meadow Vista","Newcastle","Tahoe City","Tahoe Vista","Weimar","Beckwourth","Belden","Blairsden-Graeagle","Canyon Dam","Chilcoot","Clio","Crescent Mills","Greenville","Meadow Valley","Storrie","Taylorsville","Twain","Vinton","East Quincy","Graeagle","Oroville","Portola","Quincy","Westwood","Aguanga","Coachella","Desert Center","Homeland","March Air Reserve Base","Menifee","Moreno Valley","Mountain Center","North Palm Springs","Nuevo","Thousand Palms","White Water","Wildomar","Winchester","Anza","Banning","Beaumont","Blythe","Cabazon","Calimesa","Cathedral City","Cherry Valley","Desert Hot Springs","Eagle Mountain","East Blythe","Hemet","Idyllwild","Indian Wells","Indio","La Quinta","Lake Elsinore","Mecca","Mira Loma","Norco","Palm Desert","Perris","Rancho Mirage","Riverside","Rubidoux","San Jacinto","Sun City","Sunnyslope","Temecula","Thermal","Courtland","Herald","Hood","Mather","Mcclellan","Represa","Ryde","Sloughhouse","Elverta","Galt","Isleton","North Highlands","Rio Linda","Walnut Grove","Amboy","Angelus Oaks","Bryn Mawr","Cedar Glen","Cedarpines Park","Cima","Crest Park","Earp","Essex","Forest Falls","Fort Irwin","Green Valley Lake","Guasti","Helendale","Joshua Tree","Landers","Ludlow","Lytle Creek","Mountain Pass","Nipton","Parker Dam","Patton","Red Mountain","Rimforest","Skyforest","Sugarloaf","Twentynine Palms","Vidal","Yucaipa","Adelanto","Apple Valley","Argus","Baker","Baldy Mesa","Barstow","Big Bear City","Big Bear Lake","Bloomington","Blue Jay","Blythe","Chino","Chino Hills","Colton","Crestline","Daggett","Fawnskin","Fontana","Grand Terrace","Hesperia","Highland","Hinkley","Hodge","Lockhart","Loma Linda","Lucerne Valley","Mentone","Montclair","Morongo Valley","Muscoy","Needles","Newberry Springs","Ontario","Oro Grande","Phelan","Pinon Hills","Pioneertown","Rancho Cucamonga","Redlands","Running Springs","Trona","Twin Peaks","Wrightwood","Yermo","Boulevard","Camp Pendleton","Campo","Cardiff By The Sea","Dulzura","Guatay","Jacumba","Mount Laguna","Pala","Pine Valley","Potrero","Ranchita","San Luis Rey","Santa Ysabel","Spring Valley","Tecate","Warner Springs","Alpine","Bonita","Bonsall","Borrego Springs","Coronado","Descanso","El Cajon","Escondido","Fallbrook","Imperial Beach","Jamul","Julian","Lakeside","Lemon Grove","Leucadia","Lincoln Acres","National City","Ocean Beach","Pacific Beach","Palomar Mountain","Pauma Valley","Poway","Ramona","San Ysidro","Santee","Valley Center","Vista","Clements","Farmington","French Camp","Holt","Vernalis","Victor","Woodbridge","Acampo","Lathrop","Linden","Lockeford","Thornton","Creston","Grover Beach","Harmony","San Simeon","Shandon","Avila Beach","Baywood Park","Cayucos","Los Osos","Morro Bay","Nipomo","Oceano","San Miguel","Santa Margarita","Shell Beach","Templeton","Casmalia","Los Alamos","Los Olivos","Buellton","Carpinteria","Goleta","Guadalupe","Isla Vista","Lompoc","Montecito","New Cuyama","Orcutt","Santa Barbara","Santa Ynez","Solvang","Summerland","Alleghany","Calpine","Goodyears Bar","Sierra City","Downieville","Loyalton","Sierraville","Callahan","Forks Of Salmon","Fort Jones","Gazelle","Greenview","Grenada","Hornbrook","Klamath River","Macdoel","Scott Bar","Seiad Valley","Somes Bar","Dorris","Dunsmuir","Etna","Happy Camp","Mccloud","Montague","Mount Shasta","Tulelake","Weed","Yreka","Birds Landing","Elmira","Travis AFB","Rio Vista","Suisun City","Annapolis","Bodega","Bodega Bay","Camp Meeker","Cazadero","Duncans Mills","El Verano","Eldridge","Fulton","Geyserville","Jenner","Occidental","Stewarts Point","The Sea Ranch","Valley Ford","Villa Grande","Vineburg","Boyes Hot Springs","Cotati","Forestville","Glen Ellen","Graton","Guerneville","Kenwood","Monte Rio","Rio Nido","Sebastopol","Windsor","Crows Landing","Hickman","La Grange","Denair","Empire","Hughson","Keyes","Newman","Waterford","Westley","Meridian","Nicolaus","Pleasant Grove","Rio Oso","Robbins","Sutter","Flournoy","Manton","Mill Creek","Mineral","Paskenta","Paynes Creek","Proberta","Tehama","Vina","Corning","Gerber","Los Molinos","Big Bar","Burnt Ranch","Douglas City","Hyampom","Junction City","Mad River","Salyer","Trinity Center","Zenia","Hayfork","Lewiston","Weaverville","Badger","California Hot Springs","Camp Nelson","Ducor","Kaweah","Kings Canyon National Pk","Lemon Cove","Posey","Sequoia National Park","Sultana","Traver","Waukena","Yettem","Alpaugh","Corcoran","Cutler","Dinuba","Earlimart","Farmersville","Goshen","Ivanhoe","Lindsay","Orosi","Pixley","Porterville","Richgrove","Springville","Strathmore","Terra Bella","Three Rivers","Tipton","Tulare","Visalia","Woodlake","Big Oak Flat","Dardanelle","Mi Wuk Village","Moccasin","Pinecrest","Soulsbyville","Standard","Strawberry","Chinese Camp","Columbia","Groveland","Long Barn","Tuolumne","Brandeis","Oak Park","Oak View","Point Mugu Nawc","Port Hueneme Cbc Base","Somis","Camarillo","Casitas Springs","Fillmore","Moorpark","Newbury Park","Oxnard","Piru","Port Hueneme","Santa Paula","Westlake Village","Brooks","Capay","Clarksburg","Dunnigan","Guinda","Madison","Rumsey","Yolo","Zamora","Broderick","Bryte","Esparto","Knights Landing","Woodland","Beale AFB","Browns Valley","Brownsville","Camptonville","Challenge","Dobbins","Oregon House","Rackerby","Strawberry Valley","Marysville","Olivehurst","Wheatland","Agoura Hills","American Canyon","Brentwood","Carmel Highlands","Folsom","Huntington Park","Miramonte","Sun Valley","Thousand Oaks","Mountain House","Knights Ferry","Morada","Valley Home","Santa Nella","East San Benito County","Lake Nacimiento","Martinez","Crockett","Moraga","Watsonville"};
	
	public static String getCity(String city){
    	for (int i = 0; i < cityID.length; i++) {
    		if(cityID[i].equalsIgnoreCase(city.toLowerCase().trim())){
    			return cityName[i];
    		}
    	}
    	return city;
	}
	
    protected String getOutputType(){
        return "xml";
    }

    protected SearchService getSearchService(WebApplicationContext wac){
       SearchService propServices=(SearchService)wac.getBean("SearchService");
       propServices.setRESULT_TYPE("XML");
       return  propServices;
    }

    protected Object getJSONReturnObj(Properties aProp){
        return aProp;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
    	long reqInputArrivalTime = System.currentTimeMillis();
    	Date resultdate = new Date(reqInputArrivalTime);
    	System.out.println("Calling Me @:" + sdf.format(resultdate) +", from: " + request.getRemoteAddr() +
    			", with url> "+ request.getRequestURL()+"?"+request.getQueryString());
    	
    	long startTime = reqInputArrivalTime;
        
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        SearchService propServices = this.getSearchService(wac);
        propServices.setContextPath(this.getUrl3(request));
        //propServices.setServer(this.getServer(request));
        Filter filer = new Filter();
        ArrayList<FilterItem> filterItemArrayList = new ArrayList<FilterItem>(1);
        ArrayList<FilterItem> exactFilterItemArrayList = new ArrayList<FilterItem>(1);
        ArrayList<FilterItem> multipleFilterItemArrayList = new ArrayList<FilterItem>(1);
    	ArrayList<String> keywordArrayList = new ArrayList<String>(1);
    	Vector<SimpleRange> rangeVector = new Vector<SimpleRange>(1);
    	GeoParameter geoParam = null;
//        SimpleRange aRange = new SimpleRange("price_list",null,50000);
//        filer.setRanges(new SimpleRange[]{aRange});
        int start =0;
        int limit =-1;
//        if(request.getParameter("ListingId") != null){
//        	FilterItem filterItem = new FilterItem();
//            filterItem.setField("number_MLS");
//            filterItem.setValue(request.getParameter("ListingId"));
//            filterItemArrayList.add(filterItem);
//        }
        if(request.getParameter("ListPrice") != null){
        	SimpleRange aRange;
        	String listPrice = request.getParameter("ListPrice");
        	System.out.println("List price is "+ listPrice);
        	String min = "";
        	String max = "";
        	if(!listPrice.equalsIgnoreCase("No Min-No Max")){
	        	if(listPrice.indexOf(":")!=-1){
//	        		System.out.println("listPrice : -->>"+listPrice);
	        		min = listPrice.substring(0,listPrice.indexOf(":"));
	        		max = listPrice.substring(listPrice.indexOf(":")+1,listPrice.length());
	        		aRange = new SimpleRange("price_list",min,max);
	        	}else if(listPrice.endsWith("+")){
//	        		System.out.println("listPrice +-->>"+listPrice);
	        		min = listPrice.substring(0, listPrice.indexOf("+"));
	        		aRange = new SimpleRange("price_list",min,null);
	        	}else if(listPrice.endsWith("-")){
//	        		System.out.println("listPrice - -->>"+listPrice);
	        		max = listPrice.substring(0, listPrice.indexOf("-"));
	        		aRange = new SimpleRange("price_list",null,max);
	        	}else if (listPrice.length() > 0){ // Exact match....
	        		min = listPrice.substring(0, listPrice.length());
	        		max = min;
	        		aRange = new SimpleRange("price_list",min,max);
	        	}else {
	        		aRange = new SimpleRange("price_list",null, null);
	        	}
	        	
	        	rangeVector.add(aRange);
        	}
        }        
        
        if(request.getParameter("Bedrooms") != null){
        	SimpleRange aRange;
        	String bedrooms = request.getParameter("Bedrooms");
        	String min = "";
        	String max = "";
        	if(!bedrooms.equalsIgnoreCase("No Min-No Max")){
	        	if(bedrooms.indexOf(":")!=-1){
//	        		System.out.println("Bedrooms: -->>"+bedrooms);
	        		min = bedrooms.substring(0,bedrooms.indexOf(":"));
	        		max = bedrooms.substring(bedrooms.indexOf(":")+1,bedrooms.length());
	        		aRange = new SimpleRange("number_beds_Total",min,max);
	        	}else if(bedrooms.endsWith("+")){
//	        		System.out.println("Bedrooms+ -->>"+bedrooms);
	        		min = bedrooms.substring(0, bedrooms.indexOf("+"));
	        		aRange = new SimpleRange("number_beds_Total",min,null);
	        	}else if(bedrooms.endsWith("-")){
//	        		System.out.println("Bedrooms- -->>"+bedrooms);
	        		max = bedrooms.substring(0, bedrooms.indexOf("-"));
	        		aRange = new SimpleRange("number_beds_Total",null,max);
	        	}else if (bedrooms.length() > 0){ // Exact match....
	        		min = bedrooms.substring(0, bedrooms.length());
	        		max = min;
	        		aRange = new SimpleRange("number_beds_Total",min,max);
	        	}else{
	        		aRange = new SimpleRange("number_beds_Total",null,null);
	        	}
	        	rangeVector.add(aRange);
        	}
        }
        if(request.getParameter("FullBathrooms") != null){
        	SimpleRange aRange;
        	String fullBath = request.getParameter("FullBathrooms");
        	String min = "";
        	String max = "";
        	if(!fullBath.equalsIgnoreCase("No Min-No Max")){
	        	if(fullBath.indexOf(":")!=-1){
//	        		System.out.println("FullBathrooms: -->>"+fullBath);
	        		min = fullBath.substring(0,fullBath.indexOf(":"));
	        		max = fullBath.substring(fullBath.indexOf(":")+1,fullBath.length());
	        		aRange = new SimpleRange("number_baths_Full",min,max);
	        	}else if(fullBath.endsWith("+")){
//	        		System.out.println("FullBathrooms+ -->>"+fullBath);
	        		min = fullBath.substring(0, fullBath.indexOf("+"));
	        		aRange = new SimpleRange("number_baths_Full",min,null);
	        	}else if(fullBath.endsWith("-")){
//	        		System.out.println("FullBathrooms- -->>"+fullBath);
	        		max = fullBath.substring(0, fullBath.indexOf("-"));
	        		aRange = new SimpleRange("number_baths_Full",null,max);
	        	}else if (fullBath.length() > 0){
	        		min = fullBath.substring(0, fullBath.length());
	        		max = min;
	        		aRange = new SimpleRange("number_baths_Full",min,max);
	        	}else{
	        		aRange = new SimpleRange("number_baths_Full",null,null);
	        	}
	        	rangeVector.add(aRange);
        	}
        }
        
        if(request.getParameter("SqFt") != null){
        	SimpleRange aRange;
        	String sqFt = request.getParameter("SqFt");
        	String min = "";
        	String max = "";
        	if(!sqFt.equalsIgnoreCase("No Min-No Max")){
	        	if(sqFt.indexOf(":")!=-1){
//	        		System.out.println("SqFt: -->>"+sqFt);
	        		min = sqFt.substring(0,sqFt.indexOf(":"));
	        		max = sqFt.substring(sqFt.indexOf(":")+1,sqFt.length());
	        		aRange = new SimpleRange("sqft_Structure",min,max);
	        	}else if(sqFt.endsWith("+")){
//	        		System.out.println("SqFt+ -->>"+sqFt);
	        		min = sqFt.substring(0, sqFt.indexOf("+"));
	        		aRange = new SimpleRange("sqft_Structure",min,null);
	        	}else if(sqFt.endsWith("-")){
//	        		System.out.println("SqFt- -->>"+sqFt);
	        		max = sqFt.substring(0, sqFt.indexOf("-"));
	        		aRange = new SimpleRange("sqft_Structure",null,max);
	        	}else if (sqFt.length() > 0){
	        		min = sqFt.substring(0, sqFt.length());
	        		max = min;
	        		aRange = new SimpleRange("sqft_Structure",min,max);
	        	}else{
	        		aRange = new SimpleRange("sqft_Structure",null,null);
	        	}
	        	rangeVector.add(aRange);
        	}
        }
        
        // Date range for the property.
        if(request.getParameter("Age") != null){
        	SimpleRange aRange;
        	String age = request.getParameter("Age");
        	String min = "";
        	String max = "";
        	if(!age.equalsIgnoreCase("No Min-No Max")){
	        	if(age.indexOf(":")!=-1){
	        		System.out.println("age: -->>"+age);
	        		min = age.substring(0,age.indexOf(":"));
	        		max = age.substring(age.indexOf(":")+1,age.length());
	        		aRange = new SimpleRange("date_Listing_Modification",min,max);
	        	}else if(age.endsWith("+")){
//	        		System.out.println("SqFt+ -->>"+sqFt);
	        		min = age.substring(0, age.indexOf("+"));
	        		aRange = new SimpleRange("date_Listing_Modification",min,null);
	        	}else if(age.endsWith("-")){
//	        		System.out.println("SqFt- -->>"+sqFt);
	        		max = age.substring(0, age.indexOf("-"));
	        		aRange = new SimpleRange("date_Listing_Modification",null,max);
	        	}else if (age.length() > 0){
	        		min = age.substring(0, age.length());
	        		max = min;
	        		aRange = new SimpleRange("date_Listing_Modification",min,max);
	        	}else{
	        		aRange = new SimpleRange("date_Listing_Modification",null,null);
	        	}
	        	System.out.println("Range is " + aRange.getMinValue() +", "+ aRange.getMaxValue());
	        	rangeVector.add(aRange);
        	}
        }

        
        // Range for Longitude
        if(request.getParameter("Longitude") != null){
        	SimpleRange aRange;
        	String longitude = request.getParameter("Longitude");
        	System.out.println("Longitude is "+ longitude);
        	String min = "";
        	String max = "";
        	if(longitude.indexOf(":")!=-1){
        		min = longitude.substring(0,longitude.indexOf(":"));
        		max = longitude.substring(longitude.indexOf(":")+1,longitude.length());
        		aRange = new SimpleRange("_long",min,max);
        	}else {
        		aRange = new SimpleRange("_long",null, null);
        	}	        	
	        rangeVector.add(aRange);        	
        }
        
        // Range for Latitude
        if(request.getParameter("Latitude") != null){
        	SimpleRange aRange;
        	String latitude = request.getParameter("Latitude");
        	System.out.println("Latitude is "+ latitude);
        	String min = "";
        	String max = "";
        	if(latitude.indexOf(":")!=-1){
        		min = latitude.substring(0,latitude.indexOf(":"));
        		max = latitude.substring(latitude.indexOf(":")+1,latitude.length());
        		aRange = new SimpleRange("lat",min,max);
        	}else {
        		aRange = new SimpleRange("lat",null, null);
        	}	        	
	        rangeVector.add(aRange);        	
        }
        
        // Near by homes
        // Format required is Latitude,Longitude,distance
        if(request.getParameter("NBH") != null){
        	String nbh = request.getParameter("NBH");
        	String [] s = nbh.split(",");
        	if (s.length == 3){
        		Float f = Float.valueOf(s[2]); 
        		if ( f >= 10 ) // 10 miles radius max
        			s[2] = "10";
        		else if (f < 0) // if negative distance
        			s[2] = "1";
        		geoParam = new GeoParameter(s[0], s[1], s[2]);
        	}
        }else {
        	// City and Zip are optional if NBH is provided.
	        if(request.getParameter("Zip") != null){	        	
	        	FilterItem filterItem = new FilterItem();
	            filterItem.setField("zipCode");
	            // remove the space first
	            String inZipcode = request.getParameter("Zip");
	            StringBuffer zipBuffer = new StringBuffer();
	            if (inZipcode.indexOf(",") > -1){
	            	StringTokenizer sToken = new StringTokenizer(inZipcode, ",");
	            	while (sToken.hasMoreElements()){
	            		String object = (String) sToken.nextElement();
	            		zipBuffer.append("'");
	            		zipBuffer.append(object);
	            		zipBuffer.append("'");
	            		if (sToken.countTokens() > 0)
	            			zipBuffer.append(",");
	            	}
	            }
	            else {
	            	zipBuffer.append("'");
	            	zipBuffer.append(inZipcode);
	            	zipBuffer.append("'");
	            }
	
	            //System.out.println(zipBuffer.toString());
	            filterItem.setValue(zipBuffer.toString());
	            multipleFilterItemArrayList.add(filterItem);
	
	        }
	        
	        if(request.getParameter("City") != null){
	        	FilterItem filterItem = new FilterItem();
	            filterItem.setField("name_City");
	            
	            String cityList = request.getParameter("City");
	            StringBuffer cityMod = new StringBuffer();
	            if(cityList.indexOf(",")>-1){
	            	StringTokenizer sToken = new StringTokenizer(cityList, ",");
	            	while (sToken.hasMoreElements()) {
	   					String object = (String) sToken.nextElement();
	   					cityMod.append("'");
	   					cityMod.append(getCity(object));
	   					cityMod.append("'");
	   					if(sToken.countTokens()>0)
	   						cityMod.append(",");
	   				}
	            }else{
						cityMod.append("'");
	   					cityMod.append(getCity(cityList));
	   					cityMod.append("'");
	            }
	
	            filterItem.setValue(cityMod.toString());
	            multipleFilterItemArrayList.add(filterItem);
	        }
        }
        
        // Status of property, link Active or Pending
        // For backward compatibility, Status=A. we added extra checks
        // for Status=ACTIVE or PENDING
        /*
         * if(request.getParameter("Status") != null &&
        		(request.getParameter("Status").equalsIgnoreCase("ACTIVE")||
        		request.getParameter("Status").equalsIgnoreCase("PENDING"))){
        	FilterItem filterItem = new FilterItem();
            filterItem.setField("status_Listing");
            filterItem.setValue(request.getParameter("Status"));
            if (request.getParameter("Status").equalsIgnoreCase("PENDING")){
            	filterItem.setValue(propServices.getPendingStatus());
            }           
            filterItemArrayList.add(filterItem);
        }
        */
        if(request.getParameter("Status") != null &&
        		(request.getParameter("Status").equalsIgnoreCase("ACTIVE")||
                 request.getParameter("Status").equalsIgnoreCase("PENDING"))){
        	FilterItem filterItem = new FilterItem();
            filterItem.setField("status_Listing");
            StringBuffer statusMod = new StringBuffer();
            String statusList  = null;
            if (request.getParameter("Status").equalsIgnoreCase("ACTIVE")){
            	statusList = propServices.getActiveStatus();            	
            }else if (request.getParameter("Status").equalsIgnoreCase("PENDING")){
            	statusList = propServices.getPendingStatus();
            }        
            if(statusList.indexOf(",")>-1){
            	StringTokenizer sToken = new StringTokenizer(statusList, ",");
            	while (sToken.hasMoreElements()) {
   					String object = (String) sToken.nextElement();
   					statusMod.append("'");
   					statusMod.append(object);
   					statusMod.append("'");
   					if(sToken.countTokens()>0)
   						statusMod.append(",");
   				}
            }else{
            	statusMod.append("'");
            	statusMod.append(statusList);
            	statusMod.append("'");
            }
            System.out.println("Status query..: "+ statusMod.toString());
            filterItem.setValue(statusMod.toString());
            multipleFilterItemArrayList.add(filterItem);
        }
        
        
        if(request.getParameter("ListingId") != null){
        	FilterItem filterItem = new FilterItem();
            filterItem.setField("number_MLS");         
            String listingId = request.getParameter("ListingId");
            String mlsNumberPrefix = propServices.getMlsNumberPrefix();
            StringBuffer listingIdList = new StringBuffer();
            if(listingId.indexOf(",")>-1){
            	StringTokenizer sToken = new StringTokenizer(listingId, ",");
            	while (sToken.hasMoreElements()) {
   					String object = (String) sToken.nextElement();
   					if ((mlsNumberPrefix != null)&&
   							(!mlsNumberPrefix.equals(""))
   							&&(!object.contains(mlsNumberPrefix))){
   						listingIdList.append("'"+mlsNumberPrefix);
   					}
   					else{
   						listingIdList.append("'");
   					}
   					listingIdList.append(object);
   					listingIdList.append("'");
   					if(sToken.countTokens()>0)
   						listingIdList.append(",");
   				}
            }else{
            	if ((mlsNumberPrefix != null)&&(!mlsNumberPrefix.equals(""))
            			&&(!listingId.contains(mlsNumberPrefix)))
						listingIdList.append("'"+mlsNumberPrefix);
					else
						listingIdList.append("'");            	
            	listingIdList.append(listingId);
            	listingIdList.append("'");
            }


            filterItem.setValue(listingIdList.toString());
            multipleFilterItemArrayList.add(filterItem);
            //System.out.println("got listing id "+ request.getParameter("ListingId"));
        }
        
        if(request.getParameter("ListingAgentLic") != null){
        	FilterItem filterItem = new FilterItem();
            filterItem.setField("listing_license_number");         
            String listingId = request.getParameter("ListingAgentLic");
            
            if(listingId.indexOf(",")>-1){
            	StringTokenizer sToken = new StringTokenizer(listingId, ",");
            	while (sToken.hasMoreElements()) {   					
   					keywordArrayList.add((String)sToken.nextElement());
            	}
            }else{
            	keywordArrayList.add(listingId);
            }
            //System.out.println("got listing agent lic "+ request.getParameter("ListingAgentLic"));

        }

        
        if(request.getParameter("offset") != null){
        	start = Integer.parseInt(request.getParameter("offset"));
        }
        if(request.getParameter("limit") != null){
        	limit = Integer.parseInt(request.getParameter("limit"));
        }
        String sort = request.getParameter("sort");
        if(sort != null){
        	if(sort.equalsIgnoreCase("City")){
        		sort = "name_City";
        	}else if(sort.equalsIgnoreCase("YearBuilt")){
        		sort = "year_Built";
        	}else if(sort.equalsIgnoreCase("ListPrice")){
        		sort = "price_List";
        	}else if(sort.equalsIgnoreCase("Sqft")){
        		sort = "sqft_Structure";
        	}else if(sort.equalsIgnoreCase("LotSqFt")){
        		sort = "Size_Lot";
        	}else if(sort.equalsIgnoreCase("Type")){
        		sort = "";
        	}else if(sort.equalsIgnoreCase("Bedrooms")){
        		sort = "number_beds_Total";
        	}else if(sort.equalsIgnoreCase("FullBathrooms")){
        		sort = "number_baths_Full";
        	}else if(sort.equalsIgnoreCase("ExteriorFeatures")){
        		sort = "type_Property";
        	}else if(sort.equalsIgnoreCase("none")){
        		sort = null;
        	}
        }
        	
        String sort_direction = request.getParameter("sort_direction");
        if(sort_direction != null){
        	if (sort_direction.equalsIgnoreCase("none")){
        		sort_direction = null;
        	}
        	else if(sort_direction.equalsIgnoreCase("ASC")){
        		sort_direction = "asc";
        	}else{
        		sort_direction = "desc";
        	}
        	
        }else{ //{TOD: why do we need this??
        	if(request.getParameter("ListingAgentLic") != null){
        		sort = "price_List";
        		sort_direction = "desc"; // with agent listing, they want desc
        	}else{
        		sort_direction = "asc"; // default sorting order
        	}
        		
        }
        
        // Type of property, link Single Family, Townhouse, Condominium
        if(request.getParameter("ExteriorFeatures") != null){
        	String param = request.getParameter("ExteriorFeatures");
        	FilterItem filterItem = new FilterItem();
        	filterItem.setField("type_Property");
        	List<ExteriorFeaturesData> extFeatureData = propServices.getExtFeaturesData();
        	// Getting ExFeatures list from properties files
        	if (extFeatureData != null){   
        		System.out.println("Exterior Features param is "+ param);
        		for ( ExteriorFeaturesData efd : extFeatureData){
        			if (efd.getName().equalsIgnoreCase(param)){        				
        				filterItem.setValue(efd.getInSearchFields());
        				break;
        			}
        		}
        		if (filterItem.getValue() != null){
        			System.out.println("Exterior Features value "+filterItem.getValue());
        			multipleFilterItemArrayList.add(filterItem);
        		}
        	}else{// Getting ExFeatures list from DB  		                
                filterItem.setValue(param);
                System.out.println("Exterior Features (single) "+filterItem.getValue());
                filterItemArrayList.add(filterItem);	
        	}
        	
        }
               
        
        // Adding the search parameter for Full Address
        if(request.getParameter("FullAddress") != null){
        	FilterItem filterItem = new FilterItem();
            filterItem.setField("address_Filtered");
            filterItem.setValue(request.getParameter("FullAddress"));
            filterItemArrayList.add(filterItem);
        }
        
        boolean returnOpenHouseData = false;
        if(request.getParameter("OpenHouse") != null){
        	if(request.getParameter("OpenHouse").equals("1")){
        		returnOpenHouseData = true;
        	}
        }

        // Put the keyword search (using it for license id)
        String[] filterArrayKeyword = new String[keywordArrayList.size()];
        filterArrayKeyword = keywordArrayList.toArray(filterArrayKeyword);
        filer.setKeywords(filterArrayKeyword);

        // Put range in the filter
    	SimpleRange[] sRangeArray = new SimpleRange[rangeVector.size()];
    	sRangeArray = rangeVector.toArray(sRangeArray);
    	filer.setRanges(sRangeArray);
    	
    	// Put single value item in the filter with '%value%'
        FilterItem[] filterArray = new FilterItem[filterItemArrayList.size()];
        filterArray = filterItemArrayList.toArray(filterArray);
        filer.setFilters(filterArray);
        
        // Put single value item in the filter, with exact search with 'value'
        FilterItem[] exactFilterArray = new FilterItem[exactFilterItemArrayList.size()];
        exactFilterArray = exactFilterItemArrayList.toArray(exactFilterArray);
        filer.setExactFilters(exactFilterArray);
        
        // Put the multiple values (',' separated) item in the filter.
        FilterItem[] filterItemA = new FilterItem[multipleFilterItemArrayList.size()];
    	filterItemA = multipleFilterItemArrayList.toArray(filterItemA);
    	filer.setSearchForFieldItems(filterItemA);

    	//System.out.println("time in making query:"+(new Date().getTime()-startTime)+" msecs");   
        //System.out.println("limit " + request.getParameter("limit") + ", offset " + 
        //		request.getParameter("offset") +", sort " + sort + ", sort direction "+ sort_direction);
        
    	Object returnObj = null;
        startTime = new Date().getTime();
        
        // Create a Timer and a TimerTask
        Timer timer = new Timer();
        TimerTask task = new SearchPropertyTimerTask(request, response,this.getOutputType());
        
        // Set timer for 30 sec, method takes args in milliseconds.
        timer.schedule(task, 30*1000);
        boolean timedoutResponse = true;// Default is timed out response.
    	
        try{  
        	/* for testing of timer functionality.
        	try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
            
        	
            Properties prop = propServices.searchForProperties(start, limit, sort, sort_direction, 
            		filer, geoParam, returnOpenHouseData);
            prop.setElapsedTime(BigInteger.valueOf(System.currentTimeMillis() - reqInputArrivalTime));

            if( this.getOutputType().equalsIgnoreCase("json")){
                returnObj = getJSONReturnObj(prop);
            }else{
                returnObj = prop;
            }
        }
        catch (LargeResultSetException e){
        	Errors errors = new Errors();
        	com.irets.generated.Error error = new com.irets.generated.Error();
        	error.setCode(e.getErrorCode());
        	error.setDescription(e.getMessage() );
        	errors.getError().add(error);
        	errors.setTotalcount(BigInteger.valueOf(e.getTotalCount()));
        	errors.setElapsedtime(BigInteger.valueOf(System.currentTimeMillis() - reqInputArrivalTime));
        	returnObj = errors;
        	System.out.println(e.getMessage());
        }    
        finally{
        	if (task.cancel()){
            	timedoutResponse = false;// No timeout, send normal response.          	
            }
        }
        
        System.out.println("time in database call:"+(new Date().getTime()-startTime)+" msecs");
        
        //startTime = new Date().getTime();
        //GSONHelper.serializeToJSON(prop, response.getOutputStream());
        if (!timedoutResponse){
	        if( this.getOutputType().equalsIgnoreCase("json"))
            {
	        	response.setContentType("application/json");
	        	JacksonJSONHelper.serializeToJSON(returnObj, response.getOutputStream(), response);
	        }else{
                response.setContentType("text/xml");
	        	JAXBHelper.serializeToXML(returnObj, response.getOutputStream());
            }
        }
        //System.out.println("time in making output:"+(new Date().getTime()-startTime)+" msecs");
        System.out.println("Done!!!! elapsed time: "+ (System.currentTimeMillis() - reqInputArrivalTime));
    }


    public String getUrl3(HttpServletRequest req) {
        String scheme = req.getScheme();             // http
        String serverName = req.getServerName();     // hostname.com
        int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
//        String servletPath = req.getServletPath();   // /servlet/MyServlet
//        String pathInfo = req.getPathInfo();         // /a/b;c=123
//        String queryString = req.getQueryString();          // d=789

        // Reconstruct original requesting URL
        String url = scheme+"://"+serverName+":"+serverPort+contextPath;//+servletPath;
//        if (pathInfo != null) {
//            url += pathInfo;
//        }
//        if (queryString != null) {
//            url += "?"+queryString;
//        }
        return url;
    }
    
    public String getServer( HttpServletRequest req){
    	String server = null;
    	String uri = req.getRequestURI();
    	
        if(uri.indexOf("/")>-1){
        	StringTokenizer sToken = new StringTokenizer(uri, "/");
        	if( sToken.hasMoreElements()) {
					server = (String)(sToken.nextElement());
					if (server.equals("imls"))
			    		return null;
        	}
        }
        System.out.println("server from uri is " +server);
        return server;    	
    	
    }
    
    
    private class SearchPropertyTimerTask extends java.util.TimerTask{
    	HttpServletRequest request;
    	HttpServletResponse response;
        String reqType;
    	public SearchPropertyTimerTask(HttpServletRequest request,HttpServletResponse response,String reqType) {
			// TODO Auto-generated constructor stub
    		this.request = request;
    		this.response = response;
            this.reqType = reqType;
		}
    	public void run(){
    		
    		Errors errors = new Errors();
        	com.irets.generated.Error error = new com.irets.generated.Error();
        	error.setCode("T100");
        	error.setDescription("Time out response from query: \""+request.getQueryString()+ 
        			"\" > 30 secs)." );        	
        	errors.getError().add(error);        	
        	Object returnObj = errors;
        	
    		try{
	            if(reqType.equalsIgnoreCase("json")){
	            	response.setContentType("application/json");
	            	JacksonJSONHelper.serializeToJSON(returnObj, response.getOutputStream(), response);
	            }else{
	            	response.setContentType("text/xml");
	            	JAXBHelper.serializeToXML(returnObj, response.getOutputStream());
	            }   
    		}catch (Exception e){
    			e.printStackTrace();
    		}
    	}
    }

}