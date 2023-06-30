class WebtoonModel {
  final String title;
  final String thumb;
  final String id;

  WebtoonModel.fromJson(Map<String, dynamic> json)
      : title = json["title"],
        thumb = json["thumb"],
        id = json["id"];
}
