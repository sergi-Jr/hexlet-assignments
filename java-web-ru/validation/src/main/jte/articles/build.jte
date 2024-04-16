@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page
<head>
    <meta charset="UTF-8">
</head>
@if(page.getErrors() != null)
    <ul>
        @for(var err : page.getErrors().values())
            @for(var e : err)
                <li>
                    ${e.getMessage()}
                </li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label>
            Title
            <input type="text" required name="title" value="${page.getTitle()}">
        </label>
    </div>
    <div>
        <label>
            Content
            <textarea name="content" value="${page.getContent()}"></textarea>
        </label>
    </div>
    <input type="submit" value="Create article">
</form>