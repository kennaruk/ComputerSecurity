import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ass2_5809610248 {
	private static int compareCount;
	private static String encryptPassword;
	/*I can send only one file so I generated dictionary as array of string 
		instead of separated another file */
	private static final String[] fourLettersDictionary = {"aahs", "abet", "able", "ably", "abut", "aced", "aces", "ache", "acid", "acme", "acne", "acre", "acts", "adds", "adze", "afar", "afro", "agar", "aged", "ages", "agog", "ague", "ahas", "ahem", "ahoy", "aide", "aids", "ails", "aims", "airs", "airy", "ajar", "akin", "alas", "albs", "alef", "ales", "alga", "ally", "alms", "aloe", "alps", "also", "alto", "alum", "ambo", "amen", "amid", "amok", "amps", "anal", "ands", "anew", "anon", "ante", "ants", "anus", "aped", "aper", "apes", "apex", "apps", "aqua", "arch", "arcs", "area", "ares", "aria", "arid", "aril", "arks", "arms", "army", "arts", "arty", "ashs", "ashy", "asks", "asps", "atom", "atop", "aunt", "aura", "auto", "aver", "avid", "avow", "away", "awed", "awes", "awls", "awns", "awny", "awol", "awry", "axed", "axel", "axes", "axis", "axle", "axon", "ayes", "ayin", "baas", "babe", "baby", "back", "bade", "bags", "baht", "bail", "bait", "bake", "bald", "bale", "balk", "ball", "balm", "band", "bane", "bang", "bank", "bans", "barb", "bard", "bare", "barf", "bark", "barm", "barn", "bars", "base", "bash", "bask", "bass", "bath", "bats", "baud", "bawd", "bawl", "bays", "bead", "beak", "beam", "bean", "bear", "beat", "beau", "beds", "beef", "been", "beep", "beer", "bees", "beet", "begs", "bell", "belt", "bend", "bent", "berk", "berm", "best", "beta", "beth", "bets", "bevy", "bias", "bibs", "bide", "bids", "bike", "bile", "bilk", "bill", "bind", "bins", "bios", "bird", "birr", "bite", "bits", "bitt", "blab", "blah", "blat", "bleb", "bled", "blew", "blip", "blob", "blog", "blot", "blow", "blue", "blur", "boar", "boas", "boat", "bobs", "bode", "body", "bogs", "boil", "bold", "boll", "bolt", "bomb", "bond", "bone", "bonk", "bony", "book", "boom", "boon", "boor", "boos", "boot", "bops", "bore", "born", "boss", "both", "bots", "bout", "bowl", "bows", "boxy", "boys", "brad", "brag", "bran", "bras", "brat", "bray", "bred", "brew", "brie", "brim", "bris", "brow", "bubo", "buck", "buds", "buff", "bugs", "buhl", "buhr", "bulb", "bulk", "bull", "bump", "bums", "bunk", "buns", "bunt", "buoy", "burl", "burn", "burp", "burr", "burs", "bury", "bush", "busk", "bust", "busy", "buts", "butt", "buys", "buzz", "byes", "byte", "cabs", "cads", "cafe", "cage", "cake", "calf", "call", "calm", "calx", "came", "camp", "cams", "cane", "cans", "cant", "cape", "caps", "card", "care", "carp", "cars", "cart", "case", "cash", "cask", "cast", "cats", "cave", "caws", "ceca", "cede", "cedi", "cees", "cell", "celt", "cent", "chad", "chap", "char", "chat", "chef", "chew", "chic", "chin", "chip", "chis", "chiv", "chop", "chow", "chub", "chug", "chum", "cite", "city", "clad", "clan", "clap", "claw", "clay", "clef", "clip", "clod", "clog", "clop", "clot", "club", "clue", "coal", "coat", "coax", "cobs", "cock", "coda", "code", "cods", "coed", "cogs", "coho", "coif", "coil", "coin", "cola", "cold", "cole", "colt", "coma", "comb", "come", "cone", "conk", "cons", "cook", "cool", "coop", "coos", "coot", "cope", "cops", "copy", "cord", "core", "cork", "corm", "corn", "cost", "cosy", "cots", "coup", "cove", "cowl", "cows", "coys", "cozy", "crab", "crag", "cram", "crap", "crew", "crib", "crop", "crow", "crud", "crux", "cube", "cubs", "cuds", "cued", "cues", "cuff", "cull", "cult", "cups", "curb", "curd", "cure", "curl", "curs", "curt", "cusp", "cuss", "cute", "cuts", "cwms", "cyan", "cyst", "czar", "dabs", "dado", "dads", "daft", "dame", "damn", "damp", "dams", "dank", "dare", "dark", "darn", "dart", "dash", "data", "date", "daub", "dawn", "days", "daze", "dead", "deaf", "deal", "dean", "dear", "debt", "deck", "deed", "deem", "deep", "deer", "dees", "deft", "defy", "deil", "dele", "delf", "deli", "dell", "deme", "demo", "demy", "dene", "dens", "dent", "deny", "dere", "derm", "desk", "deva", "dews", "dewy", "deys", "dhow", "dial", "dibs", "dice", "died", "dies", "diet", "digs", "dill", "dime", "dims", "dine", "ding", "dins", "dips", "dire", "dirt", "disc", "dish", "disk", "ditz", "diva", "dive", "dock", "dodo", "doer", "does", "doff", "doge", "dogs", "dole", "doll", "dolt", "dome", "done", "dons", "doom", "door", "dope", "dork", "dorm", "dose", "dote", "doth", "dots", "doty", "dove", "down", "doze", "dozy", "drab", "drag", "dram", "draw", "dreg", "drew", "drip", "drop", "drug", "drum", "dual", "dubs", "duck", "duct", "dude", "duds", "duel", "dues", "duet", "duff", "duke", "dull", "duly", "dumb", "dump", "dune", "dung", "dunk", "duos", "dupe", "dusk", "dust", "duty", "dyed", "dyer", "dyes", "dyne", "each", "earl", "earn", "ears", "ease", "east", "easy", "eats", "eave", "ebbs", "echo", "ecru", "eddy", "edge", "edgy", "edit", "eeks", "eels", "eely", "eery", "effs", "eggs", "eggy", "egos", "eked", "eker", "ekes", "elks", "ells", "elms", "else", "emir", "emit", "emus", "ends", "enol", "envy", "eons", "epic", "eras", "ergo", "ergs", "eros", "etas", "etch", "euro", "even", "ever", "eves", "evil", "ewer", "ewes", "exam", "exes", "exit", "exon", "expo", "eyed", "eyes", "face", "fact", "fade", "fads", "fail", "fain", "fair", "fake", "fall", "fame", "fang", "fans", "fare", "farm", "fast", "fate", "fats", "faun", "faux", "fave", "fawn", "faze", "fear", "feat", "feds", "feed", "feel", "fees", "feet", "fell", "felt", "fend", "fens", "fern", "feta", "feud", "fibs", "figs", "file", "fill", "film", "find", "fine", "fink", "fins", "fire", "firm", "firs", "fish", "fist", "fits", "five", "fizz", "flab", "flag", "flan", "flap", "flat", "flaw", "flax", "flay", "flea", "fled", "flee", "flew", "flex", "flip", "flit", "floe", "flog", "flop", "flow", "flox", "flub", "flue", "flux", "foal", "foam", "fobs", "foci", "foes", "fogs", "fogy", "foil", "fold", "folk", "fond", "font", "food", "fool", "foot", "fops", "fora", "fore", "fork", "form", "fort", "foul", "four", "fowl", "foxy", "fray", "free", "fret", "friz", "frog", "from", "fuel", "full", "fume", "fumy", "fund", "funk", "furs", "fury", "fuse", "fuss", "fuzz", "gabs", "gaff", "gaga", "gage", "gags", "gain", "gait", "gala", "gale", "gall", "gals", "game", "gang", "gape", "gaps", "garb", "gash", "gasp", "gate", "gave", "gawk", "gaze", "gear", "geek", "gees", "geld", "gell", "gels", "gems", "gene", "gent", "germ", "gets", "gift", "gigs", "gild", "gill", "gilt", "gimp", "gins", "gird", "girl", "girn", "gist", "give", "glad", "glee", "glen", "glia", "glib", "glob", "glow", "glue", "glug", "glum", "glut", "gnar", "gnat", "gnaw", "gnus", "goad", "goal", "goat", "gobs", "gods", "goer", "goes", "goji", "gold", "golf", "gone", "gong", "good", "goof", "goon", "goop", "goos", "gore", "gory", "gosh", "goth", "gout", "gown", "grab", "gram", "gray", "grew", "grey", "grid", "grim", "grin", "grip", "grit", "grow", "grub", "guck", "guff", "gulf", "gull", "gulp", "gums", "gunk", "guns", "guru", "gush", "gust", "guts", "guys", "gyms", "gyps", "gyre", "gyro", "hack", "hags", "hail", "hair", "half", "hall", "halo", "halt", "hams", "hand", "hang", "haps", "hard", "hare", "hark", "harm", "harp", "hash", "hasp", "hate", "hath", "hats", "haul", "have", "hawk", "haws", "hays", "haze", "hazy", "head", "heal", "heap", "hear", "heat", "heck", "heed", "heel", "heir", "held", "hell", "helm", "help", "heme", "hems", "hens", "herb", "herd", "here", "hero", "hers", "heth", "hewn", "hews", "hick", "hide", "high", "hike", "hill", "hilt", "hind", "hint", "hips", "hire", "hiss", "hits", "hive", "hoar", "hoax", "hobo", "hoed", "hoer", "hoes", "hogs", "hold", "hole", "holy", "home", "hone", "honk", "hood", "hoof", "hook", "hoop", "hoot", "hope", "hops", "horn", "hose", "host", "hots", "hour", "howl", "hows", "hubs", "hued", "hues", "huff", "huge", "hugs", "huhs", "hula", "hulk", "hull", "hump", "hums", "hung", "hunk", "hunt", "hurl", "hurt", "hush", "husk", "huts", "hymn", "hype", "hypo", "ibex", "ibis", "iced", "icer", "ices", "icky", "icon", "idea", "ides", "idle", "idly", "idol", "iffy", "ilea", "ilka", "ilks", "ills", "imam", "imps", "inch", "inks", "inky", "inns", "into", "ions", "iota", "ired", "ires", "iris", "irks", "iron", "isle", "isms", "itch", "item", "jabs", "jack", "jade", "jags", "jail", "jali", "jamb", "jams", "jars", "java", "jaws", "jays", "jazz", "jean", "jeep", "jeer", "jeli", "jell", "jerk", "jest", "jets", "jibe", "jigs", "jilt", "jink", "jinx", "jive", "jobs", "jock", "jogs", "join", "joke", "jolt", "josh", "jots", "jowl", "joys", "judo", "jugs", "juke", "july", "jump", "june", "junk", "jury", "just", "jute", "juts", "kale", "kaph", "kays", "keek", "keel", "keen", "keep", "kegs", "kelp", "kept", "kern", "keys", "kick", "kids", "kill", "kiln", "kilt", "kina", "kind", "kine", "king", "kink", "kips", "kiss", "kite", "kits", "kiwi", "knar", "knee", "knew", "knit", "knob", "knot", "know", "knur", "kook", "kudu", "kuna", "kyak", "kyat", "labs", "lace", "lack", "lacy", "lade", "lads", "lady", "lags", "laid", "lain", "lair", "lake", "lamb", "lame", "lamp", "land", "lane", "lank", "laps", "lard", "lari", "lark", "lash", "lass", "last", "late", "laud", "lava", "lave", "lawn", "laws", "lays", "laze", "lazy", "lead", "leaf", "leak", "lean", "leap", "lear", "leas", "leek", "leer", "lees", "left", "legs", "leks", "lend", "lens", "lent", "less", "lest", "lets", "leus", "levs", "levy", "lewd", "liar", "lice", "lick", "lids", "lied", "lien", "lier", "lies", "lieu", "life", "lift", "like", "lily", "limb", "lime", "limn", "limo", "limp", "limy", "line", "link", "lint", "lion", "lips", "lira", "lire", "lisp", "list", "lite", "live", "load", "loaf", "loam", "loan", "lobe", "lobs", "loch", "loci", "lock", "loco", "lode", "loft", "logo", "logs", "loin", "loll", "lone", "long", "look", "loom", "loon", "loop", "loos", "loot", "lope", "lops", "lord", "lore", "lose", "loss", "lost", "loti", "lots", "loud", "lout", "love", "lows", "luau", "lube", "luck", "luff", "luge", "lugs", "lull", "lump", "lung", "lure", "lurk", "lush", "lust", "lute", "lynx", "lyre", "mace", "mach", "made", "mage", "magi", "maid", "mail", "maim", "main", "make", "male", "mall", "malt", "mama", "mane", "mans", "many", "maps", "mara", "mare", "mark", "marl", "mars", "mart", "mash", "mask", "mass", "mast", "mate", "math", "mats", "matt", "maul", "maws", "mayo", "mays", "maze", "mead", "meal", "mean", "meat", "meek", "meet", "meld", "melt", "meme", "memo", "mend", "mens", "menu", "meow", "mere", "mesa", "mesh", "mess", "mews", "mica", "mice", "midi", "miff", "mild", "mile", "milk", "mill", "mils", "mime", "mind", "mine", "mini", "mink", "mint", "minx", "mire", "miss", "mist", "mite", "mitt", "moan", "moat", "mobs", "mock", "mode", "mods", "moho", "mold", "mole", "molt", "moms", "monk", "mood", "moon", "moor", "moos", "moot", "mope", "mops", "more", "moss", "most", "moth", "move", "mown", "mows", "much", "muck", "muff", "mugs", "mule", "mull", "mums", "muon", "murk", "muse", "mush", "musk", "must", "mute", "mutt", "myna", "myth", "nabs", "nags", "nail", "name", "nape", "naps", "naut", "nave", "navy", "nays", "nazi", "neap", "near", "neat", "neck", "need", "neon", "nerd", "nest", "nets", "nevi", "news", "newt", "next", "nibs", "nice", "nick", "nigh", "nils", "nine", "nips", "nits", "nobs", "node", "nods", "noel", "none", "noon", "nope", "norm", "nose", "nosy", "note", "noun", "nova", "nude", "nuke", "null", "numb", "nuns", "nuts", "oafs", "oaks", "oars", "oath", "oats", "obey", "oboe", "odds", "odes", "odor", "offs", "ogle", "ogre", "ohms", "oils", "oily", "oink", "okay", "okra", "oleo", "omen", "omit", "omni", "once", "ones", "only", "onto", "onus", "onyx", "oohs", "ooid", "oops", "ooze", "oozy", "opal", "open", "opts", "oral", "orbs", "orca", "ores", "oryx", "ouch", "ours", "oust", "outs", "ouzo", "oval", "oven", "over", "ovum", "owed", "ower", "owes", "owls", "owly", "owns", "oxen", "oxes", "pace", "pack", "pact", "pads", "page", "paid", "pail", "pain", "pair", "pale", "pall", "palm", "pals", "pane", "pang", "pans", "pant", "papa", "paps", "pare", "park", "pars", "part", "pass", "past", "pate", "path", "pats", "pave", "pawn", "paws", "pays", "peak", "peal", "pear", "peas", "peat", "peck", "peek", "peel", "peep", "peer", "pegs", "pelf", "pelt", "pend", "pens", "pent", "peon", "peps", "perk", "perm", "pert", "peso", "pest", "pets", "pews", "phis", "phiz", "pick", "pied", "pier", "pies", "pigs", "pike", "pile", "pili", "pill", "pimp", "pine", "ping", "pink", "pins", "pint", "pipe", "pips", "pita", "pith", "pits", "pity", "pius", "plan", "play", "plea", "pled", "plod", "plop", "plot", "plow", "ploy", "plug", "plum", "plus", "pock", "pods", "poem", "poet", "pogo", "poke", "poky", "pole", "poll", "polo", "pomp", "pond", "pony", "pooh", "pool", "poop", "poor", "pope", "pops", "pore", "pork", "porn", "port", "pose", "posh", "post", "posy", "pots", "pouf", "pour", "pout", "poxy", "pram", "pray", "prep", "prey", "prim", "prod", "prom", "prop", "pros", "prow", "psis", "pubs", "puce", "puck", "puff", "pugs", "puke", "pull", "pulp", "puma", "pump", "punk", "puns", "punt", "puny", "pupa", "pups", "pure", "purr", "push", "puts", "putt", "pyre", "qoph", "quad", "quay", "quid", "quip", "quit", "quiz", "race", "rack", "racy", "raft", "rage", "rags", "raid", "rail", "rain", "rake", "rami", "ramp", "rams", "rand", "rang", "rank", "rant", "rape", "raps", "rapt", "rare", "rash", "rasp", "rate", "rats", "rave", "raws", "rays", "raze", "razz", "read", "reak", "real", "ream", "reap", "rear", "redo", "reds", "reed", "reef", "reek", "reel", "refs", "rein", "rely", "rend", "rent", "repo", "resh", "rest", "revs", "rhos", "rial", "ribs", "rice", "rich", "rick", "ride", "rids", "riel", "rife", "riff", "rift", "rigs", "rile", "rill", "rily", "rime", "rims", "rind", "ring", "rink", "riot", "ripe", "rips", "rise", "risk", "rite", "rive", "road", "roam", "roan", "roar", "robe", "robs", "rock", "rode", "rods", "roes", "roil", "role", "roll", "romp", "rood", "roof", "rook", "room", "root", "rope", "ropy", "rose", "rosy", "rote", "rots", "roue", "rout", "rove", "rows", "rubs", "ruby", "rude", "rued", "rues", "ruff", "rugs", "ruin", "rule", "rums", "rune", "rung", "runs", "runt", "ruse", "rush", "rust", "ruts", "sack", "sacs", "safe", "saga", "sage", "sags", "sagy", "said", "sail", "sake", "saki", "sale", "salt", "same", "sand", "sane", "sang", "sank", "saps", "sari", "sash", "sass", "sate", "save", "sawn", "saws", "says", "scab", "scam", "scan", "scar", "scat", "scot", "scud", "scum", "seal", "seam", "sear", "seas", "seat", "sect", "seed", "seek", "seem", "seen", "seep", "seer", "sees", "self", "sell", "send", "sent", "sera", "sere", "serf", "seta", "sets", "sewn", "sews", "sext", "sexy", "shah", "sham", "shed", "shew", "shim", "shin", "ship", "shiv", "shmo", "shoe", "shoo", "shop", "shot", "show", "shun", "shut", "shwa", "sick", "side", "sift", "sigh", "sign", "sikh", "silk", "sill", "silo", "silt", "sine", "sing", "sink", "sins", "sips", "sire", "sirs", "site", "sits", "sitz", "size", "skew", "skid", "skim", "skin", "skip", "skis", "skit", "slab", "slam", "slap", "slat", "slaw", "slay", "sled", "slew", "slid", "slim", "slip", "slit", "slob", "sloe", "slog", "slop", "slot", "slow", "slug", "slum", "slur", "smit", "smog", "smug", "smut", "snag", "snap", "snip", "snit", "snob", "snog", "snot", "snow", "snub", "snug", "soak", "soap", "soar", "sobs", "sock", "soda", "sods", "sofa", "soft", "soil", "sold", "sole", "solo", "some", "soms", "song", "sons", "soon", "soot", "sops", "sore", "sort", "sots", "soul", "soup", "sour", "sown", "sows", "soya", "soys", "spam", "span", "spar", "spas", "spat", "spay", "sped", "spin", "spit", "spot", "spry", "spud", "spun", "spur", "stab", "stag", "star", "stat", "stay", "stem", "step", "stew", "stir", "stop", "stow", "stub", "stud", "stun", "stye", "styx", "subs", "such", "suck", "suds", "sued", "suer", "sues", "suet", "suit", "sulk", "sumo", "sump", "sums", "sung", "sunk", "suns", "sure", "surf", "swab", "swag", "swam", "swan", "swap", "swat", "sway", "swig", "swim", "swum", "sync", "tabs", "tack", "taco", "tact", "tags", "tail", "taka", "take", "tala", "talc", "tale", "talk", "tall", "tame", "tamp", "tams", "tank", "tans", "tape", "taps", "tare", "tarn", "taro", "tarp", "tars", "tart", "task", "taus", "taut", "taxa", "taxi", "teak", "teal", "team", "tear", "teas", "tech", "teed", "teem", "teen", "tees", "tell", "tend", "tens", "tent", "term", "tern", "test", "teth", "text", "than", "that", "thaw", "thee", "them", "then", "they", "thin", "this", "thou", "thru", "thud", "thug", "thus", "tick", "tics", "tide", "tidy", "tied", "tier", "ties", "tiff", "tike", "tile", "till", "tilt", "time", "tine", "ting", "tins", "tint", "tiny", "tipi", "tips", "tire", "toad", "toed", "toes", "toff", "tofu", "toga", "toil", "told", "toll", "tomb", "tome", "tone", "tong", "tons", "took", "tool", "toot", "tops", "tore", "torn", "toro", "tort", "toss", "tote", "tots", "tour", "tout", "town", "tows", "toys", "tram", "trap", "tray", "tree", "trek", "trim", "trio", "trip", "trod", "trot", "troy", "true", "tsar", "tuba", "tube", "tubs", "tuck", "tufa", "tuff", "tuft", "tugs", "tums", "tuna", "tune", "turf", "turn", "tusk", "tutu", "twig", "twin", "twit", "twos", "tyke", "type", "typo", "tyro", "tzar", "ughs", "ugly", "ukes", "ulna", "umbo", "umps", "undo", "unit", "unix", "unto", "upon", "urea", "urge", "uric", "urns", "used", "user", "uses", "uvea", "vain", "vale", "vamp", "vane", "vang", "vans", "vara", "vary", "vase", "vast", "vats", "vatu", "veal", "vear", "veer", "vees", "veil", "vein", "vela", "vend", "vent", "verb", "very", "vest", "veto", "vets", "vial", "vibe", "vice", "vied", "vies", "view", "vile", "vine", "visa", "vise", "voes", "void", "vole", "volt", "vote", "vows", "vugs", "wack", "wade", "wads", "waft", "wage", "wags", "waif", "wail", "wait", "wake", "walk", "wall", "wand", "wane", "want", "ward", "ware", "warm", "warn", "warp", "wars", "wart", "wary", "wash", "wasp", "watt", "waul", "wave", "wavy", "wawl", "waxy", "ways", "weak", "wean", "wear", "webs", "weds", "weed", "week", "ween", "weep", "weir", "weld", "well", "welt", "wend", "went", "wept", "were", "west", "wets", "wham", "what", "when", "whet", "whew", "whey", "whim", "whip", "whir", "whiz", "whoa", "whom", "whop", "whup", "wick", "wide", "wife", "wifi", "wigs", "wild", "wile", "will", "wilt", "wily", "wimp", "wind", "wine", "wing", "wink", "wins", "wipe", "wire", "wiry", "wise", "wish", "wisp", "wist", "with", "wits", "wive", "woad", "woes", "woke", "woks", "wolf", "womb", "wons", "wont", "wood", "woof", "wool", "woos", "word", "wore", "work", "worm", "worn", "wort", "wove", "wows", "wrap", "wren", "writ", "wyes", "xray", "xyst", "yack", "yaff", "yagi", "yaks", "yald", "yams", "yang", "yank", "yaps", "yard", "yare", "yarn", "yaud", "yaup", "yawl", "yawn", "yawp", "yaws", "yeah", "yean", "year", "yeas", "yegg", "yeld", "yelk", "yell", "yelm", "yelp", "yens", "yerk", "yeti", "yett", "yeuk", "yews", "yill", "yins", "yipe", "yips", "yird", "yirr", "yodh", "yods", "yoga", "yogh", "yogi", "yoke", "yolk", "yond", "yoni", "yore", "your", "yowe", "yowl", "yows", "yoyo", "yuan", "yuck", "yuga", "yuks", "yule", "yurt", "yutz", "ywis", "zags", "zany", "zaps", "zarf", "zati", "zeal", "zebu", "zeds", "zees", "zein", "zens", "zerk", "zero", "zest", "zeta", "zigs", "zinc", "zine", "zing", "zips", "ziti", "zits", "zoea", "zoic", "zone", "zonk", "zoom", "zoon", "zoos", "zori", "zulu", "zyme"};
	
	public ass2_5809610248() {
		compareCount = 0;
		encryptPassword = null;
	}
	
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static String dictionaryAttack() {
		
		for(String fourLettersWord: fourLettersDictionary) {
			//All Lower
			String hashAllLower = getMD5(fourLettersWord);
			compareCount ++;
			if( encryptPassword.equalsIgnoreCase(hashAllLower) ) 
				return fourLettersWord;
			
			//All Upper
			String hashAllUpper = getMD5(fourLettersWord.toUpperCase());
			compareCount ++;
			if( encryptPassword.equalsIgnoreCase(hashAllUpper) ) 
				return fourLettersWord.toUpperCase();
			
		}
		
		return null;
	}
	
	public static String bruteForceAttack() {
		String[] combination = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
		  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
		  "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		for(int index1 = 0; index1 < combination.length; index1 ++) 
			for(int index2 = 0; index2 < combination.length; index2 ++) 
				for(int index3 = 0; index3 < combination.length; index3 ++) 
					for(int index4 = 0; index4 < combination.length; index4 ++) {
						String combinationString = combination[index1] + combination[index2] + combination[index3] + combination[index4];
						String hashCombinationString = getMD5(combinationString);
						
						compareCount++;
						if( encryptPassword.equalsIgnoreCase(hashCombinationString) ) 
							return combinationString;
					}
				
		return null;
	}
	
	public static void printCompareTimes() {
		System.out.println("compare "+compareCount+" times");
	}
	
	public static void main(String[] args) {
		System.out.print("% crackpwd ");
		Scanner scan = new Scanner(System.in);
		String filePath = scan.nextLine();
		
		
		try {
			scan = new Scanner(new File(filePath));
			encryptPassword = scan.nextLine();
			
			String dictionaryAttackResult = dictionaryAttack();
			if(dictionaryAttackResult != null) {
				printCompareTimes();
				System.out.println("password is \""+dictionaryAttackResult+"\"");
				System.exit(0);
			}
			
			String bruteForceAttackResult = bruteForceAttack();
			if(bruteForceAttackResult != null) {
				printCompareTimes();
				System.out.println("password is \""+bruteForceAttackResult+"\"");
				System.exit(0);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(-1);
		}
	}
}
