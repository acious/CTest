CTest - 김종찬

프로젝트 설명 : 제공된 이미지 더미 리소스들을 리스트 형태로 보여주는 UI와 해당 리스트의 아이템을 클릭했을 때, 이미지를 상세보기가 가능하고 좌우로 스와이프가 가능한 UI 제공

프로젝트 스펙

- 언어 : Java8
- 아키텍쳐 : AAC ViewModel (VM + Databinding)
- 라이브러리
  - UI : RecyeclerView, Navigation Component, ViewPager2, ConstraintLayout
  - 비동기 처리 : RxJava2
  - 네트워킹 : Retrofit2, OKHttp3
  - 이미지 로더 : Glide
- 프로젝트 진입지점 : PhotoListFragment (MainActivity, nav_graph 참고)