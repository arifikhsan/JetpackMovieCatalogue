package com.arifikhsan.jetpackmoviecatalogue.repository

import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity

object MovieRepository {
    fun getMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                765123,
                "Christmas Crossfire",
                "A man foils an attempted murder, then flees the crew of would-be killers along with their intended target as a woman he's just met tries to find him.",
                1771.644,
                "https://image.tmdb.org/t/p/w500/ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                "2020-12-04",
                5.2,
                21
            )
        )
        movies.add(
            MovieEntity(
                590995,
                "The Craft: Legacy",
                "An eclectic foursome of aspiring teenage witches get more than they bargained for as they lean into their newfound powers.",
                885.329,
                "https://image.tmdb.org/t/p/w500/lhMIra0pqWNuD6CIXoTmGwZ0EBS.jpg",
                "2020-10-28",
                6.2,
                181
            )
        )
        movies.add(
            MovieEntity(
                590706,
                "Jiu Jitsu",
                "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                1465.706,
                "https://image.tmdb.org/t/p/w500/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                "2020-11-20",
                5.7,
                163
            )
        )
        movies.add(
            MovieEntity(
                646593,
                "Wander",
                "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                1353.377,
                "https://image.tmdb.org/t/p/w500/2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                "2020-12-04",
                5.4,
                28
            )
        )
        movies.add(
            MovieEntity(
                602211,
                "Fatman",
                "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                1067.602,
                "https://image.tmdb.org/t/p/w500/4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                "2020-11-13",
                5.9,
                175
            )
        )
        movies.add(
            MovieEntity(
                553604,
                "Honest Thief",
                "A bank robber tries to turn himself in because he's falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
                859.866,
                "https://image.tmdb.org/t/p/w500/zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                "2020-09-03",
                7.2,
                203
            )
        )
        movies.add(
            MovieEntity(
                729648,
                "The Dalton Gang",
                "When their brother Frank is killed by an outlaw, brothers Bob Dalton, Emmett Dalton and Gray Dalton join their local sheriff's department. When they are cheated by the law, they turn to crime, robbing trains and anything else they can steal from over the course of two years in the early 1890's. Trying to out do Jesse James, they attempt to rob two banks at once in October of 1892, and things get ugly",
                851.011,
                "https://image.tmdb.org/t/p/w500/ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                "2020-11-02",
                4.4,
                43
            )
        )
        movies.add(
            MovieEntity(
                577922,
                "Tenet",
                "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                830.095,
                "https://image.tmdb.org/t/p/w500/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                "2020-08-22",
                7.4,
                3018
            )
        )
        movies.add(
            MovieEntity(
                294963,
                "Bone Tomahawk",
                "During a shootout in a saloon, Sheriff Hunt injures a suspicious stranger. One of the villagers takes care of him in prison. One day they both disappear – only the spear of a cannibal tribe is found. Hunt and a few of his men go in search of the prisoner and his nurse.",
                497.265,
                "https://image.tmdb.org/t/p/w500/4MmTHpn2Y8emqvBgvOjufImUmKZ.jpg",
                "2015-10-23",
                6.8,
                1277
            )
        )
        movies.add(
            MovieEntity(
                682377,
                "Chick Fight",
                "When Anna Wyncomb is introduced to an an underground, all-female fight club in order to turn the mess of her life around, she discovers she is much more personally connected to the history of the club than she could ever imagine.",
                826.31,
                "https://image.tmdb.org/t/p/w500/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg",
                "2020-11-13",
                5.8,
                65
            )
        )

        return movies
    }

    fun getTVShows(): ArrayList<TVShowEntity> {
        val tvShows = ArrayList<TVShowEntity>()

        tvShows.add(
            TVShowEntity(
                82856,
                "The Mandalorian",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                1566.975,
                "https://image.tmdb.org/t/p/w500/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "2019-11-12",
                8.5,
                4014
            )
        )
        tvShows.add(
            TVShowEntity(
                97180,
                "Selena: The Series",
                "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music.",
                990.721,
                "https://image.tmdb.org/t/p/w500/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
                "2020-12-04",
                7.5,
                575
            )
        )
        tvShows.add(
            TVShowEntity(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                803.473,
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                8.6,
                6062
            )
        )
        tvShows.add(
            TVShowEntity(
                1416,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                722.985,
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "2005-03-27",
                8.1,
                4672
            )
        )
        tvShows.add(
            TVShowEntity(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                523.758,
                "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                8.5,
                6744
            )
        )
        tvShows.add(
            TVShowEntity(
                90812,
                "Industry",
                "In the cutthroat world of international finance, a group of young graduates compete for a limited set of permanent positions at a top investment bank in London. The boundaries between colleague, friend, lover, and enemy soon blur as they immerse themselves in a company culture defined as much by sex, drugs and ego as it is by deals and dividends.",
                468.154,
                "https://image.tmdb.org/t/p/w500/4G2aJJs1lXoS0n6ftZglkXtZpc6.jpg",
                "2020-11-09",
                7.0,
                44
            )
        )
        tvShows.add(
            TVShowEntity(
                69050,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                416.984,
                "https://image.tmdb.org/t/p/w500/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "2017-01-26",
                8.6,
                7129
            )
        )
        tvShows.add(
            TVShowEntity(
                71789,
                "SEAL Team",
                "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                406.217,
                "https://image.tmdb.org/t/p/w500/uTSLeQTeHevt4fplegmQ6bOnE0Z.jpg",
                "2017-09-27",
                7.8,
                751
            )
        )
        tvShows.add(
            TVShowEntity(
                62286,
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                371.442,
                "https://image.tmdb.org/t/p/w500/wGFUewXPeMErCe2xnCmmLEiHOGh.jpg",
                "2015-08-23",
                7.5,
                2842
            )
        )
        tvShows.add(
            TVShowEntity(
                89844,
                "30 Coins",
                "Father Vergara—an exorcist, boxer and ex-convict—lives in a remote village in Spain. Hoping to be lost and forgotten, Vergara’s demons catch up to him.",
                354.851,
                "https://image.tmdb.org/t/p/w500/lw70w94nzCmIVSQvtMcuAjWHfWX.jpg",
                "2020-11-29",
                6.3,
                65
            )
        )

        return tvShows
    }
}