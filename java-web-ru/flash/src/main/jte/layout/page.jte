@import gg.jte.Content
@import exercise.dto.BasePage

@param Content content
@param BasePage page = null

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Hello hexlet</title>
    </head>
    <body>
    @if(page != null && page.getFlash() != null)
        <p>${page.getFlash()}</p>
    @endif
        ${content}
    </body>
</html>