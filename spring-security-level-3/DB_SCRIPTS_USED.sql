CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[enabled] [int] NOT NULL
) ON [PRIMARY];


CREATE TABLE [dbo].[authorities](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[authority] [varchar](50) NOT NULL
) ON [PRIMARY];

INSERT INTO [dbo].[users] ([username] ,[password],[enabled]) VALUES  ('user1', 'pass1', 1);
INSERT INTO [dbo].[users] ([username] ,[password],[enabled]) VALUES  ('user2', 'pass2', 1);
INSERT INTO [dbo].[users] ([username] ,[password],[enabled]) VALUES  ('user3', 'pass3', 1);

INSERT INTO [dbo].[authorities] ([username] ,[authority]) VALUES ('user1' ,'admin');
INSERT INTO [dbo].[authorities] ([username] ,[authority]) VALUES ('user2' ,'read-write');
INSERT INTO [dbo].[authorities] ([username] ,[authority]) VALUES ('user3' ,'read-only');
