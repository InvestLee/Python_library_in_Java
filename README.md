파이썬 라이브러리에만 있는 itertools, bisect를 자바에도 구현해보는 오픈 라이브러리입니다.

- itertools 라이브러리
  - count(start, [step])
  - cycle(p)
  - repeat(elem [,n])
  - accumulate(p [,func])
  - chain(p, q, …)
  - compress(data, selectors)
  - dropwhile(pred, seq)
  - filterfalse(pred, seq)
  - groupby(iterable[, key])
  - islice(seq, [start,] stop [, step])
  - takewhile(pred, seq)
  - tee(it, n)
  - zip_longest(p, q, …)
  - product(p, q, … [repeat=1])
  - permutations(p[, r])
  - combinations(p, r)
  - combinations_with_replacement(p, r)
- bisect 라이브러리
  - bisect_left(a, x, lo=0, hi=len(a))
  - bisect_right(a, x, lo=0, hi=len(a))
  - insort_left(a, x, lo=0, hi=len(a))
  - insort_right(a, x, lo=0, hi=len(a))

## 설치 방법
### build.gralde
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
	        implementation 'com.github.InvestLee:Python_library_in_Java:Tag'
}
```

###
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.InvestLee</groupId>
	    <artifactId>Python_library_in_Java</artifactId>
	    <version>Tag</version>
	</dependency>
```
