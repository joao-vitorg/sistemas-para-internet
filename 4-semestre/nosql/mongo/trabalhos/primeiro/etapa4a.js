// Insere os usuários
db.user.insertMany([
	{
		first_name: "João",
		last_name: "Vitor",
		email: "joao@gmail.com",
		cell_phone: "34587962145",
	},
	{
		first_name: "Maria",
		last_name: "Silva",
		email: "maria@gmail.com",
		cell_phone: "11957485639",
	},
	{
		first_name: "Pedro",
		last_name: "Santos",
		email: "pedro@gmail.com",
		cell_phone: "66987456328",
	},
	{
		first_name: "Ana",
		last_name: "Santos",
		email: "ana@gmail.com",
		cell_phone: "11987456328",
	},
	{
		first_name: "Lucas",
		last_name: "Santos",
		email: "lucas@gmail.com",
		cell_phone: "34875621444",
	},
]);

// Insere 30
db.project.insertMany([
	{
		name: "Persevering logistical utilisation",
		start_date: new Date("2023-01-01"),
		end_date: new Date("2023-12-04"),
		tasks: [
			{
				title: "tantum sint conservo",
				description: "At non denuncio. Vitae pariatur cubo certe virgo sol. Suspendo video basium ocer usque sordeo.",
				start_date: new Date("2023-10-17"),
				deadline_date: new Date("2023-11-02"),
				priority: 5,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "vere tyrannus vox",
				description:
					"Volo umquam torrens alter ulterius amitto spiritus. Validus universe suffragium quaerat calculus. Unde laboriosam coma.",
				start_date: new Date("2023-09-05"),
				deadline_date: new Date("2023-09-11"),
				priority: 1,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "undique a vulgo",
				description:
					"Amet commodi unus coruscus repellendus eaque ocer dolore combibo conventus. Aveho paulatim conitor molestias audentia conservo. Tepidus corrigo crustulum tamquam virga occaecati.",
				start_date: new Date("2023-06-01"),
				deadline_date: new Date("2023-11-13"),
				priority: 4,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "curto vox colo",
				description:
					"Aufero quod tamquam voluptate currus confero comminor vomica bis somnus. Summa creo appono. Repellat atavus desino creator molestias et deinde.",
				start_date: new Date("2023-05-16"),
				deadline_date: new Date("2023-05-21"),
				priority: 2,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
		],
	},
	{
		name: "Synergized tertiary orchestration",
		start_date: new Date("2022-12-14"),
		end_date: new Date("2024-06-17"),
		tasks: [
			{
				title: "adaugeo architecto ab",
				description: "Communis adversus odit tenus fuga. Assentator arceo denuo. Ter cupressus apud illo.",
				start_date: new Date("2023-09-14"),
				deadline_date: new Date("2024-04-11"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
		],
	},
	{
		name: "De-engineered needs-based firmware",
		start_date: new Date("2023-05-23"),
		end_date: new Date("2023-11-29"),
		tasks: [
			{
				title: "commodo amicitia soluta",
				description:
					"Averto summisse sunt abundans textor timor conculco sapiente. Ab subnecto omnis tandem voluptatem clibanus alii crur stella complectus. Agnosco solio velociter temptatio aer caelum.",
				start_date: new Date("2023-08-21"),
				deadline_date: new Date("2023-10-14"),
				priority: 2,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "vicissitudo abscido adimpleo",
				description:
					"Titulus amet cinis depromo aestus conicio quidem coepi summopere decipio. Baiulus cognatus demitto sursum. Arca vomica cribro canis quam deorsum iure cibus suppono.",
				start_date: new Date("2023-07-31"),
				deadline_date: new Date("2023-09-07"),
				priority: 5,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
		],
	},
	{
		name: "Ergonomic 24 hour secured line",
		start_date: new Date("2023-02-07"),
		end_date: new Date("2024-05-06"),
		tasks: [
			{
				title: "comedo turpis abutor",
				description: "Paulatim est tenax veritatis. Tutis velum sordeo. Demitto quae titulus vacuus degenero corpus.",
				start_date: new Date("2023-07-31"),
				deadline_date: new Date("2023-08-24"),
				priority: 1,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "texo vulgaris talis",
				description:
					"Voluptas expedita vesica. Cursim somniculosus textus tenuis vero deludo utilis beneficium vigor color. Beatae sophismata contego.",
				start_date: new Date("2024-04-25"),
				deadline_date: new Date("2024-05-05"),
				priority: 3,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
		],
	},
	{
		name: "Universal system-worthy access",
		start_date: new Date("2023-03-19"),
		end_date: new Date("2024-10-09"),
		tasks: [
			{
				title: "omnis sono sum",
				description:
					"Laboriosam umbra voluptates annus acer video villa antepono videlicet. Ipsa caelum vereor colligo stipes. Thesaurus absens demo arcesso adimpleo aetas synagoga dolorum.",
				start_date: new Date("2024-06-22"),
				deadline_date: new Date("2024-09-03"),
				priority: 5,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "tantillus tamdiu volup",
				description:
					"Fuga absconditus venustas denuo. Strues adamo sapiente defungo. Solum eligendi cunctatio maxime centum deficio.",
				start_date: new Date("2024-07-28"),
				deadline_date: new Date("2024-09-17"),
				priority: 2,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
		],
	},
	{
		name: "Polarised 5th generation circuit",
		start_date: new Date("2023-09-05"),
		end_date: new Date("2024-07-02"),
		tasks: [
			{
				title: "corrupti candidus caelestis",
				description:
					"Succedo vomer cuius. Crudelis spero vitiosus texo trado patruus claustrum vetus. Certus desino veritas.",
				start_date: new Date("2024-04-09"),
				deadline_date: new Date("2024-06-13"),
				priority: 5,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "molestias volutabrum volaticus",
				description:
					"Alter ago benevolentia vapulus casso utique repudiandae. Ter usus deficio vilis commodo thesaurus cogito conicio sodalitas utpote. Dens coma amitto vaco thesis terreo vere.",
				start_date: new Date("2024-05-24"),
				deadline_date: new Date("2024-06-28"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "depraedor demonstro terra",
				description:
					"Ut dedico animi amiculum ceno cinis quaerat subseco teneo. Desolo conspergo terra. Suspendo quia dens thesaurus venio calculus absens voluptas audeo tamdiu.",
				start_date: new Date("2024-01-25"),
				deadline_date: new Date("2024-02-15"),
				priority: 3,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
		],
	},
	{
		name: "Digitized encompassing approach",
		start_date: new Date("2023-06-05"),
		end_date: new Date("2024-10-26"),
		tasks: [
			{
				title: "tabesco territo adeptio",
				description:
					"Conturbo talis agnitio tero vilitas exercitationem praesentium. Vado vitium ascit claustrum considero. Vespillo cogo subnecto votum pauci crinis credo testimonium cubicularis.",
				start_date: new Date("2023-09-14"),
				deadline_date: new Date("2024-02-07"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "compello unus beatae",
				description:
					"Auctor verto bos minima vitae. Certe comburo quas demulceo. Eaque curriculum allatus minima contigo caute placeat.",
				start_date: new Date("2023-07-01"),
				deadline_date: new Date("2024-08-16"),
				priority: 2,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
			{
				title: "thalassinus tamisium adipisci",
				description:
					"Angelus beatus deporto vinitor aequus decerno culpa conturbo capitulus subvenio. Addo solio vitiosus tergeo carmen capio canto. Coerceo tollo astrum depopulo approbo.",
				start_date: new Date("2023-10-27"),
				deadline_date: new Date("2023-11-11"),
				priority: 5,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "crur vulgaris termes",
				description:
					"Deinde amplexus copia ulciscor recusandae. Cerno molestiae sordeo clamo cimentarius vehemens. Necessitatibus corroboro congregatio aqua antea caste.",
				start_date: new Date("2023-06-12"),
				deadline_date: new Date("2024-10-11"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
		],
	},
	{
		name: "Self-enabling multi-state circuit",
		start_date: new Date("2023-08-18"),
		end_date: new Date("2024-03-08"),
		tasks: [
			{
				title: "conspergo animi claudeo",
				description:
					"Substantia coruscus aestus deleniti suadeo conicio teneo. Abeo nam tertius corrigo. Turpis tumultus dolore verecundia culpa temptatio.",
				start_date: new Date("2024-01-26"),
				deadline_date: new Date("2024-02-18"),
				priority: 1,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "delectatio vere collum",
				description:
					"Sublime peior ventus. Tersus vigor neque qui reprehenderit ultio decet excepturi tremo. Talus virga xiphias cura supra utique.",
				start_date: new Date("2024-02-07"),
				deadline_date: new Date("2024-03-08"),
				priority: 4,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "quidem totam utor",
				description:
					"Corona angulus strenuus amplexus cubicularis bestia voro tero amita. Careo spectaculum urbanus quo assumenda ratione custodia ver cupiditas maiores. Tergum aufero dolorum cubicularis contra.",
				start_date: new Date("2024-02-20"),
				deadline_date: new Date("2024-02-29"),
				priority: 1,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "bos cruentus debitis",
				description:
					"Tego vilis trado. Rem attonbitus custodia tripudio. Adduco constans derideo spectaculum patria ex suus contra.",
				start_date: new Date("2023-10-10"),
				deadline_date: new Date("2023-11-08"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
			{
				title: "victoria odit ancilla",
				description:
					"Clam spiculum avarus veritas inflammatio tepidus utor aegre in. Confero ademptio apto sponte denuo vulticulus adiuvo peccatus triumphus. Degero pecco socius.",
				start_date: new Date("2023-12-29"),
				deadline_date: new Date("2024-01-27"),
				priority: 2,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
		],
	},
	{
		name: "Customer-focused needs-based frame",
		start_date: new Date("2023-01-29"),
		end_date: new Date("2024-04-06"),
		tasks: [
			{
				title: "patior tamquam spargo",
				description:
					"Cunae vinco tertius subito valeo una aurum aliquid absens basium. Adstringo tondeo turbo tolero aedificium laboriosam ambulo approbo dolor. Vir adsum comminor cupressus.",
				start_date: new Date("2023-03-01"),
				deadline_date: new Date("2024-03-26"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "voluptate ago aut",
				description:
					"Thalassinus conitor modi deripio tabernus decens amicitia ipsum utique. Caecus dedico vallum. Carus vorax balbus testimonium utor.",
				start_date: new Date("2023-06-17"),
				deadline_date: new Date("2024-01-21"),
				priority: 2,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
			{
				title: "vulticulus aduro amitto",
				description:
					"Cedo vinum cetera demum avaritia votum xiphias ipsam sustineo. Arbor summopere vilicus. Alius excepturi denuncio vigor.",
				start_date: new Date("2023-09-28"),
				deadline_date: new Date("2023-10-14"),
				priority: 2,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "caste arcesso aranea",
				description:
					"Adsum collum defaeco verbera angulus carmen. Tendo amplexus sto clam assentator ter verbum corroboro. Ago stips suspendo.",
				start_date: new Date("2023-12-06"),
				deadline_date: new Date("2023-12-17"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "suus sopor ad",
				description:
					"Cena ratione necessitatibus. Decerno vestigium mollitia defluo. Suspendo undique complectus territo cultellus adimpleo amplitudo corrumpo possimus.",
				start_date: new Date("2023-04-13"),
				deadline_date: new Date("2024-02-08"),
				priority: 5,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
		],
	},
	{
		name: "Up-sized background core",
		start_date: new Date("2023-04-27"),
		end_date: new Date("2024-01-19"),
		tasks: [
			{
				title: "adeo optio sopor",
				description:
					"Tubineus carus utroque contego tepidus sperno excepturi. Comis dedico aufero conculco. Avarus super termes ago anser distinctio viduo vinum arbustum.",
				start_date: new Date("2023-10-23"),
				deadline_date: new Date("2023-11-23"),
				priority: 2,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
		],
	},
	{
		name: "Re-contextualized foreground attitude",
		start_date: new Date("2023-06-16"),
		end_date: new Date("2024-04-24"),
		tasks: [
			{
				title: "sollicito beatus comminor",
				description:
					"Quae adeo cito suasoria defero. Currus cunae vitiosus et debitis adeptio casus verbera demum dolorum. Pauci caecus credo veritatis clam esse decipio.",
				start_date: new Date("2023-08-30"),
				deadline_date: new Date("2024-02-25"),
				priority: 1,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "quo talus dolor",
				description:
					"Summopere bestia velit arto. Reprehenderit artificiose arguo suadeo creator delinquo somnus vero catena. Vito vae vivo.",
				start_date: new Date("2024-04-08"),
				deadline_date: new Date("2024-04-16"),
				priority: 3,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "ipsam vestigium bibo",
				description:
					"Alias depromo universe porro validus virgo vitiosus. Abstergo coniecto cotidie. Tripudio caveo voluptas tutis studio degero aliqua.",
				start_date: new Date("2023-07-06"),
				deadline_date: new Date("2024-02-05"),
				priority: 2,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "cervus candidus tripudio",
				description:
					"Amita ascisco absorbeo verbum comptus vulnero acsi acsi speculum. Spiculum accommodo aureus. Coepi decens deprimo cultura tutis.",
				start_date: new Date("2023-11-03"),
				deadline_date: new Date("2023-12-28"),
				priority: 2,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
		],
	},
	{
		name: "Reactive context-sensitive open architecture",
		start_date: new Date("2023-07-01"),
		end_date: new Date("2024-09-20"),
		tasks: [
			{
				title: "colo conculco vesco",
				description:
					"Vilitas nam terreo clibanus venia urbs complectus vulgo dolores tabella. Aestas callide adfectus adficio vox caelum. Deserunt patruus necessitatibus.",
				start_date: new Date("2024-04-20"),
				deadline_date: new Date("2024-07-05"),
				priority: 2,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "amoveo careo stips",
				description:
					"Coruscus appositus carcer occaecati cometes crapula vergo vitiosus tutamen decretum. Sol acerbitas stella speculum decet. Temporibus verbum compono approbo solum verumtamen vicissitudo sulum aperio crudelis.",
				start_date: new Date("2024-03-10"),
				deadline_date: new Date("2024-05-12"),
				priority: 3,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "autem adinventitias creator",
				description:
					"Comitatus comparo ascit incidunt aranea veniam tumultus ventosus. Appositus adulescens amet sequi conturbo amita. Et ulterius laboriosam repellendus debilito abduco trepide centum ager.",
				start_date: new Date("2024-09-01"),
				deadline_date: new Date("2024-09-10"),
				priority: 3,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "cogo arcesso cohaero",
				description:
					"Accommodo aspicio tutamen eos tyrannus videlicet congregatio solvo bene saepe. Deserunt sonitus unde solio sustineo tristis decipio vinitor. Calculus vesica uredo.",
				start_date: new Date("2024-05-06"),
				deadline_date: new Date("2024-08-04"),
				priority: 2,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
		],
	},
	{
		name: "Configurable grid-enabled collaboration",
		start_date: new Date("2023-02-19"),
		end_date: new Date("2024-02-20"),
		tasks: [
			{
				title: "candidus cohibeo spectaculum",
				description:
					"Velum canonicus adhuc antiquus terminatio volo recusandae. Autus spero concido una repellendus acsi ceno autus teres. Agnosco vulgo esse baiulus vester animadverto compello caries testimonium ea.",
				start_date: new Date("2023-07-15"),
				deadline_date: new Date("2024-01-24"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "molestiae theatrum cum",
				description:
					"Depraedor cibo suggero accusamus suadeo coma testimonium dicta vilitas curriculum. Bibo tego sperno truculenter ater varius complectus autus quis aestivus. Optio cervus nisi communis aegre valens tutis.",
				start_date: new Date("2024-01-29"),
				deadline_date: new Date("2024-01-29"),
				priority: 1,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
			{
				title: "paens arx cohors",
				description:
					"Attollo dolorem viridis demoror viscus clibanus acceptus. Arcesso usque stillicidium tabella blandior ducimus tibi tenus amplexus. Combibo video cupressus barba conturbo tot vinum temeritas collum.",
				start_date: new Date("2023-11-02"),
				deadline_date: new Date("2023-11-14"),
				priority: 3,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "supellex vito tener",
				description:
					"Patruus magnam debilito cur cenaculum decor acidus. Eius audax teres adfero cur cuppedia. Basium administratio attollo supellex absum sed summa recusandae.",
				start_date: new Date("2024-01-13"),
				deadline_date: new Date("2024-01-23"),
				priority: 1,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
		],
	},
	{
		name: "Down-sized object-oriented leverage",
		start_date: new Date("2023-01-14"),
		end_date: new Date("2023-12-15"),
		tasks: [
			{
				title: "cunabula tunc brevis",
				description:
					"Alius confugo taedium terror sursum cogo valde aperte subnecto aggero. Celo dolorum armarium callide antiquus color. Dedico ocer alo.",
				start_date: new Date("2023-02-01"),
				deadline_date: new Date("2023-07-03"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
			{
				title: "communis abscido thermae",
				description:
					"Commodo aegre umbra appositus praesentium ante. Video torrens utroque somniculosus aperiam. Cariosus argentum coadunatio acidus comburo argentum agnitio aspernatur.",
				start_date: new Date("2023-05-06"),
				deadline_date: new Date("2023-07-19"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
		],
	},
	{
		name: "Front-line empowering core",
		start_date: new Date("2023-10-31"),
		end_date: new Date("2024-03-14"),
		tasks: [
			{
				title: "adficio laborum timidus",
				description:
					"Carus audacia depulso. Cur depulso aurum desipio curia quidem cubitum nesciunt. Sol degusto arbor vindico aurum coepi solitudo eius sub.",
				start_date: new Date("2024-01-23"),
				deadline_date: new Date("2024-01-30"),
				priority: 2,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "curatio demens trado",
				description:
					"Spero turba depopulo cupiditas summopere eos dolor decipio. Tripudio clamo vulpes ars triumphus desparatus. Tempore aequitas convoco coruscus laudantium vinitor volo vulticulus.",
				start_date: new Date("2024-02-28"),
				deadline_date: new Date("2024-03-06"),
				priority: 2,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "cruentus vicissitudo deleniti",
				description:
					"Cruciamentum placeat stella carpo dolores dolor. Derideo sumptus tametsi. Studio spero amor triumphus amplexus perspiciatis vae catena.",
				start_date: new Date("2024-03-07"),
				deadline_date: new Date("2024-03-10"),
				priority: 5,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
		],
	},
	{
		name: "Self-enabling methodical capability",
		start_date: new Date("2023-05-28"),
		end_date: new Date("2024-06-01"),
		tasks: [
			{
				title: "solvo nihil vomer",
				description:
					"Comitatus corrupti adsum vulpes suffragium quibusdam abeo defetiscor cui demulceo. Tondeo solitudo cunctatio. Tepesco stella ago adduco aeneus illo audacia coma viriliter cerno.",
				start_date: new Date("2023-12-17"),
				deadline_date: new Date("2024-02-27"),
				priority: 2,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
			{
				title: "esse casus subito",
				description:
					"At quae cuius rerum laboriosam tersus defungo cur aggero iusto. Cauda alii libero degenero. Vomica addo pariatur desino templum.",
				start_date: new Date("2023-08-06"),
				deadline_date: new Date("2024-02-17"),
				priority: 2,
				status: "Concluida",
				user: ObjectId("65442e6c91637644bd6b946d"),
				link: null,
			},
		],
	},
	{
		name: "Cloned contextually-based moderator",
		start_date: new Date("2023-03-22"),
		end_date: new Date("2024-02-23"),
		tasks: [
			{
				title: "amita cursim tabernus",
				description:
					"Confero deleniti alioqui adimpleo voluptates adopto decretum canonicus. Textus perferendis decens advenio ara acervus triumphus suasoria. Virtus terra cogo adeo vesper caelum.",
				start_date: new Date("2023-06-25"),
				deadline_date: new Date("2023-07-25"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
		],
	},
	{
		name: "Ergonomic uniform installation",
		start_date: new Date("2023-06-14"),
		end_date: new Date("2023-12-07"),
		tasks: [
			{
				title: "undique degenero aggero",
				description:
					"Tunc succurro teres vox curatio decimus. Sustineo deludo valeo atque apparatus. Beatus reprehenderit capto credo decimus vulticulus sophismata est aureus alius.",
				start_date: new Date("2023-07-11"),
				deadline_date: new Date("2023-12-02"),
				priority: 3,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
			{
				title: "deludo arbor hic",
				description:
					"Alii ancilla repudiandae cubicularis vinculum custodia spero aveho. Adaugeo officia asporto vel decumbo aestivus aufero. Quidem vigor aut consequatur adaugeo tubineus ultra sto.",
				start_date: new Date("2023-09-03"),
				deadline_date: new Date("2023-10-02"),
				priority: 3,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "vehemens catena comedo",
				description:
					"Claudeo demens vado vel bibo delectatio custodia. Quas cultellus sunt credo depromo volutabrum degusto decens. Distinctio desipio arma suus amplitudo deprecator carcer.",
				start_date: new Date("2023-08-20"),
				deadline_date: new Date("2023-10-29"),
				priority: 2,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
			{
				title: "comburo audeo laborum",
				description:
					"Canto adopto defero arcesso. Coaegresco approbo alienus curto altus deporto adnuo denego acceptus. Clibanus impedit voluptates.",
				start_date: new Date("2023-11-06"),
				deadline_date: new Date("2023-11-12"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "amita sumo iusto",
				description:
					"Viduo cogito vinum aequitas curiositas vulgaris. Cogo neque adeptio. Peior acidus cavus volo desipio assentator.",
				start_date: new Date("2023-10-29"),
				deadline_date: new Date("2023-11-26"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
		],
	},
	{
		name: "Triple-buffered next generation task-force",
		start_date: new Date("2023-07-28"),
		end_date: new Date("2024-07-26"),
		tasks: [
			{
				title: "acceptus tamdiu stabilis",
				description:
					"Aggredior desolo carus cupiditate excepturi. Cribro concido benigne creo maiores ventito. Combibo adsidue solium tibi calcar excepturi utroque cresco taedium caterva.",
				start_date: new Date("2024-03-04"),
				deadline_date: new Date("2024-07-02"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "admoneo reprehenderit conculco",
				description:
					"Demergo vinum combibo blanditiis chirographum stultus assumenda. Harum tui vetus. Conscendo denego calco contra.",
				start_date: new Date("2024-02-03"),
				deadline_date: new Date("2024-04-01"),
				priority: 5,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "spargo cena colligo",
				description:
					"Alii absorbeo ultra laborum clibanus vae blandior adamo. Coaegresco quos venio. Synagoga laboriosam aro suffragium ver voluptatibus venustas iusto.",
				start_date: new Date("2023-10-20"),
				deadline_date: new Date("2023-11-11"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946f"),
				link: null,
			},
			{
				title: "spiculum confido voro",
				description:
					"Uredo cursim nam cena deficio adipisci deleo tremo. Eligendi utor tergo. Votum cura peccatus abutor assentator vulgo.",
				start_date: new Date("2023-10-22"),
				deadline_date: new Date("2024-07-20"),
				priority: 1,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "vita congregatio nisi",
				description:
					"Ultra demitto animadverto aureus. Defessus labore curvo angustus caterva ab vae curis cras bos. Supra surculus aiunt provident paens.",
				start_date: new Date("2024-02-04"),
				deadline_date: new Date("2024-07-05"),
				priority: 4,
				status: "Em Progresso",
				user: ObjectId("65442e6c91637644bd6b946e"),
				link: null,
			},
		],
	},
	{
		name: "Decentralized bi-directional moderator",
		start_date: new Date("2023-03-22"),
		end_date: new Date("2024-05-18"),
		tasks: [
			{
				title: "carus libero aro",
				description:
					"Cibus uterque demo. Suffoco civitas verbum demens adflicto attero calamitas verto calamitas vere. Assumenda blanditiis amicitia tutis vulnus vilitas vesica accusantium ipsam.",
				start_date: new Date("2023-05-26"),
				deadline_date: new Date("2023-08-23"),
				priority: 4,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b946c"),
				link: null,
			},
			{
				title: "patior terror vilis",
				description:
					"Crepusculum amicitia inflammatio deficio claro comedo apostolus thalassinus sulum thermae. Amplus approbo traho aequus strenuus xiphias aspernatur molestiae cauda venio. Aestas surculus carus adfero templum pauper creator cattus placeat.",
				start_date: new Date("2023-07-21"),
				deadline_date: new Date("2023-12-25"),
				priority: 5,
				status: "Pendente",
				user: ObjectId("65442e6c91637644bd6b9470"),
				link: null,
			},
		],
	},
]);
